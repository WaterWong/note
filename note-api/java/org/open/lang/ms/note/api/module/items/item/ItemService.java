package org.open.lang.ms.note.api.module.items.item;

import org.soul.base.support.service.IBaseCrudService;

import java.util.List;

public interface ItemService extends IBaseCrudService<Item, String> {

    List<ItemRecordResult> recent(int size,String createUserId);

    ItemEditModel saveOrUpdate(ItemEditModel addVo);

    /**
     * 全文
     * @param word
     * @return
     */
    List<Item> fullSearch(String createUserId, String word,String type);
}
