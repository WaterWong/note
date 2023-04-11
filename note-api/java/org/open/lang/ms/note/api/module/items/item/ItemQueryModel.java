package org.open.lang.ms.note.api.module.items.item;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.soul.base.support.model.common.BasePagingModel;

/**
 * 分页查询对象
 */
@ApiModel(value = "詞條列表查询对象")
public class ItemQueryModel extends BasePagingModel {

    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "日文")
    private String japanese;
    @ApiModelProperty(value = "平假名")
    private String hiragana;
    @ApiModelProperty(value = "中文")
    private String chinese;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }
}
