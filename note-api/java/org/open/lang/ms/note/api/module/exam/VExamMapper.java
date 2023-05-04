package org.open.lang.ms.note.api.module.exam;

import org.apache.ibatis.annotations.Mapper;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseReadOnlyMapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VExamMapper extends IBaseReadOnlyMapper<VExam, String> {
    
}
