package org.open.lang.ms.note.api.module.items.item;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;

@Getter
@Setter
@TableName("item")
public class Item extends BaseEntity<String> {

    /**
     *
     */
    public final static String FIELD_ID = "id";
    /**
     * 詞條類型: 1=單詞, 2=句子, 3=语法
     */
    public final static String FIELD_TYPE = "type";
    /**
     * 日文
     */
    public final static String FIELD_JAPANESE = "japanese";
    /**
     * 假名
     */
    public final static String FIELD_HIRAGANA = "hiragana";
    /**
     * 中文
     */
    public final static String FIELD_CHINESE = "chinese";

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 詞條類型: 1=單詞, 2=句子
     */
    private String type;
    /**
     * 日文
     */
    private String japanese;
    /**
     * 假名
     */
    private String hiragana;
    /**
     * 中文
     */
    private String chinese;


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
