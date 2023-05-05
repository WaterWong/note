package org.open.lang.ms.note.api.module.items.item;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.result.IJsonResult;

import java.util.Date;

/**
 * 详情显示的数据内容
 */
@Getter
@Setter
@ApiModel(value = "詞條详情数据")
public class ItemInfoResult implements IJsonResult {
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
    @ApiModelProperty(value = "")
    private String updateUserId;
    @ApiModelProperty(value = "")
    private String updateUser;
    @ApiModelProperty(value = "")
    private Date updateTime;

    /**
     * 读音(位置)
     */
    private int soundPosition;
}
