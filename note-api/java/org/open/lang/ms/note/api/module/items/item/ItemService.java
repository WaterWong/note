package org.open.lang.ms.note.api.module.items.item;

import org.soul.base.support.service.IBaseCrudService;

import java.util.List;

public interface ItemService extends IBaseCrudService<Item, String> {

    ItemRecordResult oneWord(String word, String createUserId);

    List<ItemRecordResult> recent(int pageNo, int pageSize, String createUserId);

    ItemEditModel saveOrUpdate(ItemEditModel addVo);

    /**
     * 全文
     * @param word
     * @return
     */
    @Deprecated(since = "1.0.1")
    List<Item> fullSearch(String createUserId, String word,String type);

    /**
     * 按条件查询
     * @param condition
     * @return
     */
    List<Item> searchByCondition(ItemSearchCondition condition);

    boolean understood(String itemId);
}
