package org.open.lang.ms.note.api.module.exam.log;

import org.apache.ibatis.annotations.Mapper;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ExamLogMapper extends IBaseCrudMapper<ExamLog, String> {
    
}
