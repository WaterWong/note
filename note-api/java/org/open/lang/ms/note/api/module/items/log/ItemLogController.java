package org.open.lang.ms.note.api.module.items.log;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.soul.base.bean.BeanTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 詞條-日誌 增删改查
 */
@RestController
@RequestMapping(value = "/item/log")
@Tag(name = "詞條-日誌 ")
public class ItemLogController {

    @Autowired
    private ItemLogService itemLogService;

    @GetMapping("/one")
    public List<Map<String, Integer>> stat(@RequestParam(name="itemId") String itemId) {
        String userId = UserTool.currentUser().getId();
        return itemLogService.statByItemIdAndCreateUserId(itemId,userId);
    }

    @PostMapping("/save")
    public boolean save(ItemLogEditModel itemLogEditModel) {
        ItemLog itemLog = new ItemLog();
        BeanTool.copyProperties(itemLogEditModel,itemLog);
        itemLogService.insert(itemLog);
        return itemLog.getId() != null;
    }

}
