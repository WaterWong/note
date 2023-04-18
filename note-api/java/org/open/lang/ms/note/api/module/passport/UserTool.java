package org.open.lang.ms.note.api.module.passport;

import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.soul.ms.user.provider.entity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserTool {

    /**
     * 获取当前用户信息
     *
     * @return
     */
    public static UserInfoModel currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null
                && authentication.getPrincipal() instanceof UserInfoModel sysUser
        ) {
            return sysUser;
        }
        return null;
    }
}
