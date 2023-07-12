package org.open.lang.ms.note.api.module.items.stat;

import java.util.List;

public interface ItemStatService {

    List<ItemStatDateRange> statByDateRange(ItemStatCondition dateRange);

    List<ItemStatType> statByType(ItemStatCondition condition);


}
