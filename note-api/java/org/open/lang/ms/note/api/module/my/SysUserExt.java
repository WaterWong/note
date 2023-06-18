package org.open.lang.ms.note.api.module.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.bean.IEntity;

@Getter
@Setter
@TableName("sys_user_ext")
public class SysUserExt implements IEntity<String> {


    public static final String AVATAR = "avatar";

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String avatar;


}
