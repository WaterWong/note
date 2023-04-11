package org.open.lang.ms.note.api.module.items.log;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.model.common.BaseEditModel;

/**
 * 编辑的模型vo
 */
@ApiModel(value = "詞條-日誌 编辑")
@Getter
@Setter
public class ItemLogEditModel extends BaseEditModel<String> {
    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "")
    private String itemId;
    @ApiModelProperty(value = "日誌類型: 1=創建, 2=查看, 3=編輯 ")
    private String logType;
}


