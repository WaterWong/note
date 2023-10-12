package org.open.lang.ms.note.api.module.items.item;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.model.common.BaseEditModel;

/**
 * 编辑的模型vo
 */
@Getter
@Setter
@Schema(description = "詞條编辑")
public class ItemEditModel extends BaseEditModel<String> {
    @Schema(description = "")
    private String id;
    @Schema(description = "詞條類型: 1=單詞, 2=句子")
    private String type;
    @Schema(description = "日文")
    private String japanese;
    @Schema(description = "假名")
    private String hiragana;
    @Schema(description = "中文")
    private String chinese;

    /**
     * 是否:懂了(掌握了,免测试)
     */
    private Boolean isUnderstood;

    /**
     * 读音(位置)
     */
    private int soundPosition;
}
