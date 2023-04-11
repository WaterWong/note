package org.open.lang.ms.note.api.module.items.log;

import io.swagger.annotations.Api;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 詞條-日誌 增删改查
 */
@RestController
@RequestMapping(value = "/item/log")
@Api(tags = "詞條-日誌 ")
public class ItemLogController {

    @Autowired
    private ItemLogService itemLogService;

    @GetMapping("/one")
    public List<Map<String, Integer>> stat(@RequestParam String itemId) {
        String userId = UserTool.currentUser().getId();
        return itemLogService.statByItemIdAndCreateUserId(itemId,userId);
    }

    @PostMapping("/save")
    public boolean save(ItemLogEditModel itemLogEditModel) {
        ItemLog itemLog = itemLogService.insertToEntity(itemLogEditModel);
        return itemLog.getId() != null;
    }

}
