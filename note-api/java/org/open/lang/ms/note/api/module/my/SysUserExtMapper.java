package org.open.lang.ms.note.api.module.my;

import org.apache.ibatis.annotations.Mapper;
import org.open.lang.ms.note.api.module.items.item.ItemRecordResult;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysUserExtMapper extends IBaseCrudMapper<SysUserExt, String> {

    List<ItemRecordResult> recent(int size);
}
