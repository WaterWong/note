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

    public final static String FIELD_IS_UNDERSTOOD= "isUnderstood";

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 詞條類型: 1=單詞, 2=句子
     */
    private String type;

    /**
     * 读音(位置)
     */
    private int soundPosition;
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

    /**
     * 是否:懂了(掌握了,免测试)
     */
    private Boolean isUnderstood;

}
