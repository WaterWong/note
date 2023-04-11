package org.open.lang.ms.note.api.module.items.log;

import org.soul.base.support.service.IBaseCrudService;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ItemLogService extends IBaseCrudService<ItemLog, String> {

    List<Map<String, Integer>> statByItemIdAndCreateUserId(String itemId, String userId);
}
