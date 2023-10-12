package org.open.lang.ms.note.api.module.items.log;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.model.common.BaseEditModel;

/**
 * 编辑的模型vo
 */
@Schema(description = "詞條-日誌 编辑")
@Getter
@Setter
public class ItemLogEditModel extends BaseEditModel<String> {
    @Schema(description = "")
    private String id;
    @Schema(description = "")
    private String itemId;
    @Schema(description = "日誌類型: 1=創建, 2=查看, 3=編輯 ")
    private String logType;
}


