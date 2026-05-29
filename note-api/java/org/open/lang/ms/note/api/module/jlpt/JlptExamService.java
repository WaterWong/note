package org.open.lang.ms.note.api.module.jlpt;

import org.open.lang.ms.note.api.module.jlpt.answer.JlptExamAnswer;
import org.open.lang.ms.note.api.module.jlpt.answer.JlptExamAnswerMapper;
import org.open.lang.ms.note.api.module.jlpt.record.JlptExamRecord;
import org.open.lang.ms.note.api.module.jlpt.record.JlptExamRecordMapper;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamAnswerSaveModel;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamCondition;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamFinishModel;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamResult;
import org.soul.ability.data.rdb.mybatis.service.BaseCrudService;
import org.soul.base.lang.string.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JlptExamService extends BaseCrudService<JlptExam, JlptExamMapper, String> {

    private static final String STATUS_RUNNING = "RUNNING";
    private static final String STATUS_PAUSED = "PAUSED";
    private static final String STATUS_FINISHED = "FINISHED";
    private static final long IDLE_PAUSE_MS = 5L * 60L * 1000L;

    @Autowired
    private JlptExamAnswerMapper answerMapper;

    @Autowired
    private JlptExamRecordMapper recordMapper;

    public int historyCount(JlptExamCondition condition) {
        return mapper.historyCount(condition);
    }

    public List<JlptExamResult> historyList(JlptExamCondition condition) {
        List<JlptExam> exams = mapper.historyList(condition);
        List<JlptExamResult> results = new ArrayList<>();
        if (exams == null) {
            return results;
        }
        for (JlptExam exam : exams) {
            List<JlptExamRecord> records = recordMapper.listByExamId(exam.getId());
            autoPauseIfIdle(exam, records);
            results.add(buildResult(exam, records));
        }
        return results;
    }

    public List<JlptExamAnswer> answers(JlptExamCondition condition) {
        return answerMapper.listByCondition(condition);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean saveAnswers(JlptExamAnswerSaveModel model) {
        answerMapper.deleteByCondition(model);
        if (model.getAnswers() == null) {
            return true;
        }
        for (JlptExamAnswer answer : model.getAnswers()) {
            if (StringTool.isBlank(answer.getCorrectAnswer())) {
                continue;
            }
            answer.setId(null);
            answer.setLevel(model.getLevel());
            answer.setExamYm(model.getExamYm());
            answerMapper.insert(answer);
        }
        return true;
    }

    public boolean clearAnswers(JlptExamCondition condition) {
        answerMapper.deleteByCondition(condition);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean clearHistory(JlptExamCondition condition) {
        recordMapper.deleteByCondition(condition);
        mapper.deleteByCondition(condition);
        return true;
    }

    public JlptExam start(JlptExamCondition condition) {
        JlptExam exam = new JlptExam();
        exam.setLevel(condition.getLevel());
        exam.setExamYm(condition.getExamYm());
        exam.setStatus(STATUS_RUNNING);
        exam.setStartTime(new Date());
        this.insert(exam);
        return exam;
    }

    @Transactional(rollbackFor = Exception.class)
    public JlptExam pause(JlptExamFinishModel model) {
        JlptExam exam = mapper.get(model.getId());
        if (exam == null) {
            return null;
        }
        JlptExamCondition condition = new JlptExamCondition();
        condition.setLevel(exam.getLevel());
        condition.setExamYm(exam.getExamYm());
        condition.setCreateUserId(exam.getCreateUserId());
        Map<String, String> answerMap = buildAnswerMap(condition);

        recordMapper.deleteByExamId(exam.getId());
        if (model.getRecords() != null) {
            for (JlptExamRecord record : model.getRecords()) {
                record.setId(null);
                record.setExamId(exam.getId());
                record.setCorrectAnswer(answerMap.get(key(record.getSectionType(), record.getQuestionNo())));
                record.setResult(calcResult(record.getUserAnswer(), record.getCorrectAnswer()));
                recordMapper.insert(record);
            }
        }
        exam.setStatus(STATUS_PAUSED);
        exam.setPauseTime(new Date());
        mapper.updateOnly(exam, JlptExam.FIELD_STATUS, JlptExam.FIELD_PAUSE_TIME);
        return exam;
    }

    @Transactional(rollbackFor = Exception.class)
    public JlptExamResult finish(JlptExamFinishModel model) {
        JlptExam exam = mapper.get(model.getId());
        if (exam == null) {
            return null;
        }

        JlptExamCondition condition = new JlptExamCondition();
        condition.setLevel(exam.getLevel());
        condition.setExamYm(exam.getExamYm());
        condition.setCreateUserId(exam.getCreateUserId());
        Map<String, String> answerMap = buildAnswerMap(condition);

        recordMapper.deleteByExamId(exam.getId());
        if (model.getRecords() != null) {
            for (JlptExamRecord record : model.getRecords()) {
                record.setId(null);
                record.setExamId(exam.getId());
                record.setCorrectAnswer(answerMap.get(key(record.getSectionType(), record.getQuestionNo())));
                record.setResult(calcResult(record.getUserAnswer(), record.getCorrectAnswer()));
                recordMapper.insert(record);
            }
        }

        exam.setStatus(STATUS_FINISHED);
        exam.setFinishTime(new Date());
        mapper.updateOnly(exam, JlptExam.FIELD_STATUS, JlptExam.FIELD_FINISH_TIME);

        List<JlptExamRecord> records = recordMapper.listByExamId(exam.getId());
        return buildResult(exam, records);
    }

    private void autoPauseIfIdle(JlptExam exam, List<JlptExamRecord> records) {
        if (!STATUS_RUNNING.equals(exam.getStatus())) {
            return;
        }
        Date lastActive = resolveLastActiveTime(exam, records);
        if (lastActive == null) {
            return;
        }
        if (System.currentTimeMillis() - lastActive.getTime() <= IDLE_PAUSE_MS) {
            return;
        }
        exam.setStatus(STATUS_PAUSED);
        exam.setPauseTime(new Date());
        mapper.updateOnly(exam, JlptExam.FIELD_STATUS, JlptExam.FIELD_PAUSE_TIME);
    }

    private Date resolveLastActiveTime(JlptExam exam, List<JlptExamRecord> records) {
        Date lastActive = exam.getStartTime();
        if (records == null) {
            return lastActive;
        }
        for (JlptExamRecord record : records) {
            if (StringTool.isBlank(record.getUserAnswer())) {
                continue;
            }
            Date recordTime = record.getUpdateTime() != null ? record.getUpdateTime() : record.getCreateTime();
            if (recordTime != null && (lastActive == null || recordTime.after(lastActive))) {
                lastActive = recordTime;
            }
        }
        return lastActive;
    }

    private Boolean calcResult(String userAnswer, String correctAnswer) {
        if (StringTool.isBlank(userAnswer) || StringTool.isBlank(correctAnswer)) {
            return false;
        }
        return userAnswer.equals(correctAnswer);
    }

    private String key(String sectionType, Integer questionNo) {
        return sectionType + "#" + questionNo;
    }

    private Map<String, String> buildAnswerMap(JlptExamCondition condition) {
        List<JlptExamAnswer> answers = answerMapper.listByCondition(condition);
        Map<String, String> answerMap = new HashMap<>();
        for (JlptExamAnswer answer : answers) {
            answerMap.put(key(answer.getSectionType(), answer.getQuestionNo()), answer.getCorrectAnswer());
        }
        return answerMap;
    }

    private JlptExamResult buildResult(JlptExam exam, List<JlptExamRecord> records) {
        JlptExamResult result = new JlptExamResult();
        result.setExam(exam);
        result.setRecords(records);
        int questionCount = records == null ? 0 : records.size();
        int doubtCount = 0;
        int correctCount = 0;
        if (records != null) {
            for (JlptExamRecord record : records) {
                if ("y".equalsIgnoreCase(record.getDoubtFlag())) {
                    doubtCount++;
                }
                if (Boolean.TRUE.equals(record.getResult())) {
                    correctCount++;
                }
            }
        }
        result.setQuestionCount(questionCount);
        result.setDoubtCount(doubtCount);
        result.setCorrectCount(correctCount);
        result.setErrorCount(questionCount - correctCount);
        BigDecimal correctRate = questionCount == 0
                ? BigDecimal.ZERO
                : BigDecimal.valueOf(correctCount)
                    .multiply(BigDecimal.valueOf(100))
                    .divide(BigDecimal.valueOf(questionCount), 2, RoundingMode.HALF_UP);
        result.setCorrectRate(correctRate);
        return result;
    }
}
