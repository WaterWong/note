package org.open.lang.ms.note.api.module.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.open.lang.ms.note.api.consts.CodeEnum;
import org.soul.ability.security.common.tools.PasswordTool;
import org.soul.base.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper mapper;

    @Autowired
    private PasswordTool passwordTool;

    @Override
    @Transactional
    public SysUser signUp(SysUser sysUser) {
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

    @Override
    public SysUser get(String username) {
        return mapper.selectOne(new QueryWrapper<SysUser>()
                .eq("username", username)
        );
    }
}
