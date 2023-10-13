package org.open.lang.ms.note.api.module.items.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Roger
 */
@Setter
@Getter
@Schema(description = "词条查询条件")
public class ItemSearchCondition {

    @Schema(description = "词条类型")
    String type;

    @Schema(description = "词条内容")
    String word;

    @Schema
    ItemFieldRange fieldRange = ItemFieldRange.ALL;

    String  createUserId;


}
