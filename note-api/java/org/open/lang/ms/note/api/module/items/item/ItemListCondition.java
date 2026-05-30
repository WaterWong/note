package org.open.lang.ms.note.api.module.items.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "词条列表查询条件")
public class ItemListCondition {

    @Schema(description = "页码")
    private int pageNo = 1;

    @Schema(description = "每页条数")
    private int pageSize = 10;

    @Schema(description = "日期范围")
    private DateRange dateRange = DateRange.ALL;

    @Schema(description = "词条类型: 0=全部, 1=单词, 2=句子")
    private String itemType = "0";

    @Schema(description = "是否掌握: null=全部, true=是, false=否")
    private Boolean isUnderstood;

    @Schema(description = "列表日期范围")
    public enum DateRange {
        ALL,
        TODAY,
        YESTERDAY,
        DAYS_3,
        DAYS_7,
        DAYS_15,
        DAYS_30
    }
}
