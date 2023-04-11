package org.open.lang.ms.note.api.module.items.favorite;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;
import org.soul.base.bean.IEntity;

import java.io.Serial;
import java.util.Date;

@Setter
@Getter
@TableName("item_favorite")
public class ItemFavorite extends BaseEntity<String> {

    public final static String FIELD_ID = "id";
    public final static String FIELD_ITEM_ID = "item_id";
    public final static String FIELD_CREATE_USER_ID = "createUserId";
    public final static String FIELD_CREATE_USER = "createUser";
    public final static String FIELD_CREATE_TIME = "createTime";

    @Serial
    private static final long serialVersionUID = 5853988512027361051L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    private String itemId;

}
