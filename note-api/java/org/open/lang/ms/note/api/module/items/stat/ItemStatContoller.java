package org.open.lang.ms.note.api.module.items.stat;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/item/stat")
@Tag(name = "詞條统计")
public class ItemStatContoller {

    @Autowired
    private ItemStatService itemStatServer;

    @RequestMapping(value = "/dateRange", method = RequestMethod.POST)
    List<ItemStatDateRange> dateRange(@RequestBody ItemStatCondition condition) {
        UserInfoModel sysUser = UserTool.currentUser();
        condition.setCreateUserId(sysUser.getId());
        return itemStatServer.statByDateRange(condition);
    }

    @RequestMapping(value = "/type", method = RequestMethod.POST)
    List<ItemStatType> type(@RequestBody ItemStatCondition condition) {
        UserInfoModel sysUser = UserTool.currentUser();
        condition.setCreateUserId(sysUser.getId());
        return itemStatServer.statByType(condition);
    }
}
