package org.open.lang.ms.note.api.module.items.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;

@Getter
@Setter
@TableName("item_log")
public class ItemLog extends BaseEntity<String> {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String itemId;

    /**
     * 日誌類型: 1=創建, 2=查看, 3=編輯
     */
    private String logType;

}
