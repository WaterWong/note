package org.open.lang.ms.note.api.module.exam;

import org.apache.ibatis.annotations.Mapper;
import org.open.lang.ms.note.api.module.items.item.Item;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ExamMapper extends IBaseCrudMapper<Exam, String> {

    List<Item> generate(ExamCondition examCondition);
}
