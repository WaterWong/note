package org.open.lang.ms.note.api.module.jlpt.answer;

import org.apache.ibatis.annotations.Mapper;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamCondition;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JlptExamAnswerMapper extends IBaseCrudMapper<JlptExamAnswer, String> {

    List<JlptExamAnswer> listByCondition(JlptExamCondition condition);

    int deleteByCondition(JlptExamCondition condition);
}
