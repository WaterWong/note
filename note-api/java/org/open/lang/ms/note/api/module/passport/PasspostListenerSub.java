package org.open.lang.ms.note.api.module.passport;

import org.open.lang.ms.note.api.module.sys.vo.SignUpVo;
import org.open.lang.ms.note.api.module.user.UserService;
import org.soul.ability.security.common.tools.PasswordTool;
import org.soul.ability.security.spring.core.authc.jwt.JwtTokenGenerator;
import org.soul.ability.security.spring.core.exception.AccountNotFoundException;
import org.soul.ability.security.spring.core.exception.PassportException;
import org.soul.ability.security.spring.core.passport.PassportEvent;
import org.soul.base.bean.BeanTool;
import org.soul.base.web.WebResult;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.soul.ms.user.login.support.PassportListener;
import org.soul.ms.user.provider.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Primary
@Component
public class PasspostListenerSub extends PassportListener {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    private PasswordTool passwordTool;

    @Override
    public WebResult onLoginFailure(PassportEvent passportEvent) {
        PassportException e = passportEvent.getPassportException();
        if (e != null && e instanceof AccountNotFoundException) {
            //用户不存在时,直接注册一个
            Authentication authentication = (Authentication) passportEvent.getData();
            SysUser sysUser = toUser(authentication);
            SignUpVo signUpVo =  signUp(sysUser);
            return WebResult.success(signUpVo);
        } else {
            return super.onLoginFailure(passportEvent);
        }
    }

    private SysUser toUser(Authentication authentication) {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        return sysUser;
    }


    private SignUpVo signUp(SysUser sysUser) {
        SysUser user = userService.signUp(sysUser);
        SignUpVo vo = new SignUpVo();
        if (user == null) {
            return vo;
        }
        vo.setUsername(user.getUsername());
        UserInfoModel userInfoModel = new UserInfoModel();
        BeanTool.copyProperties(user, userInfoModel);
        vo.setToken(jwtTokenGenerator.generate(userInfoModel));
        return vo;
    }
}
