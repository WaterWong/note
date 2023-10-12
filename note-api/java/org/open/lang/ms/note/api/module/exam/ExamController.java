package org.open.lang.ms.note.api.module.exam;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.open.lang.ms.note.api.module.exam.log.ExamLog;
import org.open.lang.ms.note.api.module.exam.log.IExamLogService;
import org.open.lang.ms.note.api.module.exam.vo.ExamInfoResult;
import org.open.lang.ms.note.api.module.items.item.Item;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "測驗接口")
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private IExamService examService;

    @Autowired
    private IVExamService vExamService;

    @Autowired
    private IExamLogService examLogService;

    @PostMapping("/list")
    public List<VExam> list() {
        UserInfoModel userInfoModel = UserTool.currentUser();
        return vExamService.list(userInfoModel.getId());
    }

    @PostMapping("/doStart")
    public ExamInfoResult doStart(@RequestBody ExamCondition examCondition) {
        UserInfoModel userInfoModel = UserTool.currentUser();
        examCondition.setCreateUser(userInfoModel.getUsername());
        return examService.doStart(examCondition);

    }

    @PostMapping("/doSubmit")
    public boolean odSubmit(@RequestBody ExamLog examLog) {
        return examLogService.insert(examLog) > 0;
    }

    @PostMapping("/doNext")
    public Item doNext(@RequestBody ExamCondition examCondition) {
        UserInfoModel userInfoModel = UserTool.currentUser();
        return examService.doNext(userInfoModel.getUsername());
    }

    @PostMapping("/doFinish")
    public List<Exam> doFinish(Exam exam) {
        UserInfoModel userInfoModel = UserTool.currentUser();
        return examService.list(userInfoModel.getId());
    }

}
