package org.open.lang.ms.note.api.module.photo.tag;

import org.apache.ibatis.annotations.Mapper;
import org.open.lang.ms.note.api.module.items.item.ItemRecordResult;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FilesTagMapper extends IBaseCrudMapper<FilesTag, String> {

    List<ItemRecordResult> recent(int size);
}
