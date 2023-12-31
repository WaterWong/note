package org.open.lang.ms.note.api.module.my;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.open.lang.ms.note.api.consts.CodeEnum;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.soul.base.web.WebResult;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.time.Instant;
import java.util.Date;

/**
 * 我的
 */
@RestController
@RequestMapping(value = "/my")
@Tag(name = "我的")
public class MyController {

    @Autowired
    private SysUserExtService sysUserExtService;

    @RequestMapping(value = "/doAvatar", method = RequestMethod.POST)
    public WebResult doAvatar(@Valid @RequestBody SysUserExt addVo) {
        UserInfoModel sysUser = UserTool.currentUser();
        addVo.setId(sysUser.getId());
        int rs = sysUserExtService.insertOrUpdate(addVo);
        if ( rs > 0) {
            return WebResult.success(addVo);
        }
        return new WebResult(CodeEnum.MY_AVATAR_FAIL.getCode());
    }

}
