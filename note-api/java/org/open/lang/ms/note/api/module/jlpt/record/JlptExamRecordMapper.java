package org.open.lang.ms.note.api.module.jlpt.record;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.open.lang.ms.note.api.module.jlpt.vo.JlptExamCondition;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JlptExamRecordMapper extends IBaseCrudMapper<JlptExamRecord, String> {

    List<JlptExamRecord> listByExamId(@Param("examId") String examId);

    int deleteByExamId(@Param("examId") String examId);

    int deleteByCondition(JlptExamCondition condition);
}
