package org.open.lang.ms.note.api.module.exam;

import org.open.lang.ms.note.api.module.exam.vo.ExamInfoResult;
import org.open.lang.ms.note.api.module.items.item.Item;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.soul.base.bean.BeanTool;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private VExamService vExamService;

    @PostMapping("/list")
    public List<VExam> list() {
        UserInfoModel userInfoModel = UserTool.currentUser();
        return vExamService.list(userInfoModel.getId());
    }

    @PostMapping("/doStart")
    public ExamInfoResult doStart() {
        UserInfoModel userInfoModel = UserTool.currentUser();
        Exam exam = new Exam();
        int rs = examService.insert(exam);
        if (rs > 0) {
            return BeanTool.copyProperties(exam, new ExamInfoResult());
        }
        return null;
    }

    @PostMapping("/doSubmit")
    public void odSubmit() {

    }

    @PostMapping("/doNext")
    public Item doNext(@RequestBody ExamCondition examCondition) {
        UserInfoModel userInfoModel = UserTool.currentUser();
        examCondition.setCreateUser(userInfoModel.getUsername());
        return examService.generate(examCondition);
    }

    @PostMapping("/doFinish")
    public List<Exam> doFinish(Exam exam) {
        UserInfoModel userInfoModel = UserTool.currentUser();
        return examService.list(userInfoModel.getId());
    }

}
