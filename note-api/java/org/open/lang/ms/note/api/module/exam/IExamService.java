package org.open.lang.ms.note.api.module.exam;

import org.open.lang.ms.note.api.module.exam.vo.ExamInfoResult;
import org.open.lang.ms.note.api.module.items.item.Item;
import org.soul.base.support.service.IBaseReadOnlyService;

import java.util.List;

public interface IExamService extends IBaseReadOnlyService<Exam, String> {

    List<Exam> list(String createUserId);

    ExamInfoResult doStart(ExamCondition examCondition);

    Item doNext(String username);
}
