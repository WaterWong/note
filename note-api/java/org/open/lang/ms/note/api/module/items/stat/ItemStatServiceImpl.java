package org.open.lang.ms.note.api.module.items.stat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemStatServiceImpl implements ItemStatService {

    @Autowired
    private ItemStatMapper itemStatMapper;

    public List<ItemStatDateRange> statByDateRange(ItemStatCondition condition) {
        return itemStatMapper.statByDateRange(condition);
    }

    public List<ItemStatType> statByType(ItemStatCondition condition) {
        return itemStatMapper.statByType(condition);

    }

}
