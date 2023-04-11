package org.open.lang.ms.note.api.module.passport;

import org.open.lang.ms.note.api.module.sys.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserTool {

    /**
     * 获取当前用户信息
     *
     * @return
     */
    public static SysUser currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null
                && authentication.getPrincipal() instanceof SysUser sysUser
        ) {
            return sysUser;
        }
        return null;
    }
}
