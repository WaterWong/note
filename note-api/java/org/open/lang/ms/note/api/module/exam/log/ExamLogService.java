package org.open.lang.ms.note.api.module.exam.log;

import org.soul.ability.data.rdb.mybatis.service.BaseCrudService;
import org.springframework.stereotype.Component;


@Component
public class ExamLogService extends BaseCrudService<ExamLog, ExamLogMapper, String> implements IExamLogService {


}