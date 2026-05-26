package org.open.lang.ms.note.api.module.jlpt;

import org.apache.ibatis.annotations.Mapper;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamCondition;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface JlptExamMapper extends IBaseCrudMapper<JlptExam, String> {

    int historyCount(JlptExamCondition condition);
}
