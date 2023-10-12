package org.open.lang.ms.note.api.module.sys;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.open.lang.ms.note.api.module.sys.vo.SignUpVo;
import org.open.lang.ms.note.api.module.user.UserService;
import org.soul.ability.security.spring.core.authc.jwt.JwtTokenGenerator;
import org.soul.base.bean.BeanTool;
import org.soul.base.web.WebResult;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.soul.ms.user.provider.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Operation(summary = "",
            description = "",
            parameters = {
                @Parameter(name = "登录信息",description = "用户名,密码等")
            }
    )
    @PostMapping("/signUp")
    public SignUpVo signUp(@RequestBody SysUser sysUser) {
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

    @ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
    public WebResult unique(Exception e) {
        if (e.getMessage().contains("Unique index")) {
            return new WebResult("user exists", "10001"); //unknown
        }
        return new WebResult("db error", "10000"); //unknown

    }
}
