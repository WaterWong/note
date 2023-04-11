package org.open.lang.ms.note.api.module.items.item;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.result.IJsonResult;
import java.util.*;

/**
 * 分页查询结果列表数据
 */
@Setter
@Getter
@ApiModel(value = "詞條列表行数据")
public class ItemRecordResult implements IJsonResult {
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
    @ApiModelProperty(value = "")
    private String createUserId;
    @ApiModelProperty(value = "")
    private String createUser;
    @ApiModelProperty(value = "")
    private Date createTime;

    private boolean isFavorite = false;


}
