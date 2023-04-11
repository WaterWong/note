package org.open.lang.ms.note.api.module.items.favorite;

import org.apache.ibatis.annotations.Mapper;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ItemFavoriteMapper extends IBaseCrudMapper<ItemFavorite, String> {
    
}
