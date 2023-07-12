package org.open.lang.ms.note.api.module.items.stat;

import org.apache.ibatis.annotations.Mapper;
import org.open.lang.ms.note.api.module.items.item.Item;
import org.open.lang.ms.note.api.module.items.item.ItemRecordResult;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemStatMapper extends IBaseCrudMapper<Item, String> {

    List<ItemStatDateRange> statByDateRange(ItemStatCondition dateRange);

    List<ItemStatType> statByType(ItemStatCondition condition);
}
