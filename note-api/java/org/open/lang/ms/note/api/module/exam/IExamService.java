package org.open.lang.ms.note.api.module.exam;

import org.soul.base.support.service.IBaseCrudService;
import org.soul.base.support.service.IBaseReadOnlyService;

import java.util.List;

public interface IExamService extends IBaseReadOnlyService<Exam, String> {

    List<Exam> list(String createUserId);
}
