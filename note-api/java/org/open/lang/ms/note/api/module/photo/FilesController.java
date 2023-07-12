package org.open.lang.ms.note.api.module.photo;

import io.swagger.annotations.Api;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.open.lang.ms.note.base.BaseCrudController;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文件
 */
@RestController
@RequestMapping(value = "/photo")
@Api(tags = "文件")
public class FilesController extends BaseCrudController<String, FilesService, Files> {

    //@Override
    //@RequestMapping(value = CommonRouter.BaseCrud.ADD, method = RequestMethod.POST)
    //public String add(@Valid @RequestBody Files addVo) {
    //    return super.add(addVo);
    //}

    @RequestMapping("/list")
    List<Files> list( @RequestBody  FilesCondition filesCondition) {
        UserInfoModel sysUser = UserTool.currentUser();
        filesCondition.setCreateUserId(sysUser.getId());
        return biz.search(filesCondition);
    }
}
