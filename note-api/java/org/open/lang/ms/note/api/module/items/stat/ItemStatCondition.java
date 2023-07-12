package org.open.lang.ms.note.api.module.items.stat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemStatCondition {

    private String createUserId;

    private DateRange dateRange = DateRange.WEEK;

    private String timezone = "GMT+09:00";

    private int getLimit() {
        switch (dateRange) {
            case WEEK -> { return 7; }
            case MONTH-> { return 31;}
            case YEAR -> {return 366;}
            default -> {
                return 7;
            }
        }
    }

}
