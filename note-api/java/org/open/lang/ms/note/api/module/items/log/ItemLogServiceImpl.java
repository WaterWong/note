package org.open.lang.ms.note.api.module.items.log;

import org.soul.ability.data.rdb.mybatis.service.BaseCrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemLogServiceImpl extends BaseCrudService<ItemLog, ItemLogMapper, String> implements ItemLogService {

    @Override
    public List<Map<String, Integer>> statByItemIdAndCreateUserId(String itemId, String userId) {
        List<Map<String, Integer>> maps = mapper.statByItemIdAndCreateUserId(itemId, userId);
        return maps;
    }
}