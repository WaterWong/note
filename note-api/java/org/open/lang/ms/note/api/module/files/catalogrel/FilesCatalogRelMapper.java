package org.open.lang.ms.note.api.module.files.catalogrel;

import org.apache.ibatis.annotations.Mapper;
import org.open.lang.ms.note.api.module.items.item.ItemRecordResult;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FilesCatalogRelMapper extends IBaseCrudMapper<FilesCatalogRel, String> {

    List<ItemRecordResult> recent(int size);
}
