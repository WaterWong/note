package org.open.lang.ms.note.api.module.user;

import org.open.lang.ms.note.api.consts.CodeEnum;
import org.soul.ability.security.common.tools.PasswordTool;
import org.soul.base.exception.ServiceException;
import org.soul.ms.user.provider.data.mapper.SysUserMapper;
import org.soul.ms.user.provider.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SysUserMapper mapper;

    @Autowired
    private PasswordTool passwordTool;

    @Transactional
    public SysUser signUp(SysUser sysUser) {
        sysUser.setUsername(sysUser.getUsername().toLowerCase());
        String password = sysUser.getPassword();
        sysUser.setPassword(passwordTool.encodePassword(password, sysUser.getUsername()));
        try {
            int rs = mapper.insert(sysUser);
            if (rs > 0) {
                sysUser.setPassword("");
                return sysUser;
            }
        } catch (DuplicateKeyException e) {
            throw new ServiceException(CodeEnum.USER_EXIST, e.getMessage());
        }
        return null;
    }

}
