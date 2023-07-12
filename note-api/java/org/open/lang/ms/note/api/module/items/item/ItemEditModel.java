package org.open.lang.ms.note.api.module.items.item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.model.common.BaseEditModel;

/**
 * 编辑的模型vo
 */
@Getter
@Setter
@ApiModel(value = "詞條编辑")
public class ItemEditModel extends BaseEditModel<String> {
    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "詞條類型: 1=單詞, 2=句子")
    private String type;
    @ApiModelProperty(value = "日文")
    private String japanese;
    @ApiModelProperty(value = "假名")
    private String hiragana;
    @ApiModelProperty(value = "中文")
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
