package org.open.lang.ms.note.api.module.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.ability.security.spring.core.authc.UserDetailAdapter;
import org.soul.base.bean.IEntity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@TableName
public class SysUser extends UserDetailAdapter implements IEntity<String> {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    private String username;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
