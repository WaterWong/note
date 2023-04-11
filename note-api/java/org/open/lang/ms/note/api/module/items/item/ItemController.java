package org.open.lang.ms.note.api.module.items.item;

import io.swagger.annotations.Api;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.open.lang.ms.note.api.module.sys.SysUser;
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
    public List<ItemRecordResult> recent(@RequestParam(defaultValue = "10") int size) {
        SysUser sysUser = UserTool.currentUser();
        return this.itemService.recent(size, sysUser.getId());
    }

    @RequestMapping(value = {"/remove"}, method = {RequestMethod.POST})
    public boolean delete(@RequestBody @Valid ItemEditModel model) {
        return this.itemService.deleteById(model.getId());
    }


}
