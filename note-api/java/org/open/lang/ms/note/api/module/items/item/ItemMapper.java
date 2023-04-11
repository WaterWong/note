package org.open.lang.ms.note.api.module.items.item;

import org.apache.ibatis.annotations.Mapper;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper extends IBaseCrudMapper<Item, String> {

    List<ItemRecordResult> recent(int size);
}
