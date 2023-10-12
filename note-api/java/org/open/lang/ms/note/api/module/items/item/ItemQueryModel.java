package org.open.lang.ms.note.api.module.items.item;

import io.swagger.v3.oas.annotations.media.Schema;

import org.soul.base.support.model.common.BasePagingModel;

/**
 * 分页查询对象
 */
@Schema(description = "詞條列表查询对象")
public class ItemQueryModel extends BasePagingModel {

    @Schema(description = "ID")
    private String id;
    @Schema(description = "日文")
    private String japanese;
    @Schema(description = "平假名")
    private String hiragana;
    @Schema(description = "中文")
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
