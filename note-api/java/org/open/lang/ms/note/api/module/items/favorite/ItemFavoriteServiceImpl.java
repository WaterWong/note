package org.open.lang.ms.note.api.module.items.favorite;

import org.soul.ability.data.rdb.mybatis.service.BaseCrudService;
import org.soul.base.query.Criteria;
import org.soul.base.query.enums.OperatorEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemFavoriteServiceImpl extends BaseCrudService<ItemFavorite, ItemFavoriteMapper, String> implements ItemFavoriteService {

    @Override
    public List<ItemFavorite> searchByItemIdByCreateUser(List<String> itemIds, String createUserId) {
        Criteria criteria = Criteria.and(
                Criteria.add(ItemFavorite.FIELD_ITEM_ID, OperatorEnum.IN,itemIds),
                Criteria.add(ItemFavorite.FIELD_CREATE_USER_ID, OperatorEnum.EQ,createUserId)
        );
        return mapper.search(criteria);
    }
}