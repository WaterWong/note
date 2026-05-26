package org.open.lang.ms.note.api.module.jlpt;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.open.lang.ms.note.api.module.jlpt.answer.JlptExamAnswer;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamAnswerSaveModel;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamCondition;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamFinishModel;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamIdModel;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamResult;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "JLPT考试接口")
@RestController
@RequestMapping("/jlptExam")
public class JlptExamController {

    @Autowired
    private JlptExamService jlptExamService;

    @PostMapping("/historyCount")
    public int historyCount(@RequestBody JlptExamCondition condition) {
        fillUser(condition);
        return jlptExamService.historyCount(condition);
    }

    @PostMapping("/historyList")
    public List<JlptExamResult> historyList(@RequestBody JlptExamCondition condition) {
        fillUser(condition);
        return jlptExamService.historyList(condition);
    }

    @PostMapping("/answers")
    public List<JlptExamAnswer> answers(@RequestBody JlptExamCondition condition) {
        fillUser(condition);
        return jlptExamService.answers(condition);
    }

    @PostMapping("/saveAnswers")
    public boolean saveAnswers(@RequestBody JlptExamAnswerSaveModel model) {
        fillUser(model);
        return jlptExamService.saveAnswers(model);
    }

    @PostMapping("/clearAnswers")
    public boolean clearAnswers(@RequestBody JlptExamCondition condition) {
        fillUser(condition);
        return jlptExamService.clearAnswers(condition);
    }

    @PostMapping("/clearHistory")
    public boolean clearHistory(@RequestBody JlptExamCondition condition) {
        fillUser(condition);
        return jlptExamService.clearHistory(condition);
    }

    @PostMapping("/start")
    public JlptExam start(@RequestBody JlptExamCondition condition) {
        fillUser(condition);
        return jlptExamService.start(condition);
    }

    @PostMapping("/pause")
    public JlptExam pause(@RequestBody JlptExamIdModel model) {
        return jlptExamService.pause(model.getId());
    }

    @PostMapping("/finish")
    public JlptExamResult finish(@RequestBody JlptExamFinishModel model) {
        return jlptExamService.finish(model);
    }

    private void fillUser(JlptExamCondition condition) {
        UserInfoModel userInfoModel = UserTool.currentUser();
        condition.setCreateUserId(userInfoModel.getId());
    }
}
