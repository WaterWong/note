package org.open.lang.ms.note.api.module.exam;

import org.soul.ability.data.rdb.mybatis.imapper.IBaseReadOnlyMapper;
import org.soul.base.support.service.IBaseReadOnlyService;

import java.util.List;

public interface IVExamService extends IBaseReadOnlyService<VExam, String> {

    List<VExam> list(String createUserId);
}
