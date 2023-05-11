package org.open.lang.ms.note.api.module.items.item;

import io.swagger.annotations.Api;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.soul.base.lang.collections.ListTool;
import org.soul.base.lang.string.StringTool;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 詞條增删改查
 */
@RestController
@RequestMapping(value = "/item")
@Api(tags = "詞條")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ItemEditModel save(@Valid @RequestBody ItemEditModel addVo) {
        return itemService.saveOrUpdate(addVo);
    }

    @RequestMapping(value = "/recent", method = RequestMethod.GET)
    public List<ItemRecordResult> recent(
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam int pageNo)
    {
        UserInfoModel sysUser = UserTool.currentUser();
        return this.itemService.recent(pageNo,pageSize, sysUser.getId());
    }

    @RequestMapping(value = {"/remove"}, method = {RequestMethod.POST})
    public boolean delete(@RequestBody @Valid ItemEditModel model) {
        return this.itemService.deleteById(model.getId());
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Item> search(@RequestParam String type,@RequestParam String word) {
        if (StringTool.isBlank(word)) {
            return ListTool.newArrayList();
        }
        UserInfoModel sysUser = UserTool.currentUser();
        return itemService.fullSearch(sysUser.getId(),word,type);
    }


}
