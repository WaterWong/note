package org.open.lang.ms.note.api.module.items.favorite;

import org.soul.base.support.service.IBaseCrudService;

import java.util.List;

public interface ItemFavoriteService extends IBaseCrudService<ItemFavorite, String> {

    List<ItemFavorite> searchByItemIdByCreateUser(List<String> itemIds, String createUserId);

}
