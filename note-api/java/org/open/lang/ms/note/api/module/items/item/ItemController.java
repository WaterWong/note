package org.open.lang.ms.note.api.module.items.item;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.open.lang.ms.note.api.consts.TopicEnum;
import org.open.lang.ms.note.api.module.CommonErrorCodeEnum;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.soul.base.exception.ServiceException;
import org.soul.base.lang.collections.ListTool;
import org.soul.base.lang.string.StringTool;
import org.soul.ms.user.common.vo.login.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * 詞條增删改查
 */
@RestController
@ControllerAdvice
@RequestMapping(value = "/item")
@Tag(name = "詞條")
public class ItemController {

    @Autowired
    private ItemService itemService;

    //只适用于 ws publish
    //@MessageMapping({TopicEnum.ITEM_ADDED})
    //@SendTo(value = {TopicEnum.TOPIC + TopicEnum.ITEM_ADDED})
    @SendToUser(value = {TopicEnum.TOPIC + TopicEnum.ITEM_ADDED},broadcast = false)
    @SubscribeMapping
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ItemEditModel save(@Valid @RequestBody ItemEditModel addVo) {
        try {
            return itemService.saveOrUpdate(addVo);
        } catch (DuplicateKeyException e) {
            throw new ServiceException(CommonErrorCodeEnum.DATA_EXIST,e);
        }
    }

    @RequestMapping(value = "/oneWord", method = RequestMethod.GET)
    public ItemRecordResult recent( @RequestParam(required = true) String word) {
        UserInfoModel sysUser = UserTool.currentUser();
        return this.itemService.oneWord(word,sysUser.getId());
    }

    @RequestMapping(value = "/recent", method = RequestMethod.GET)
    public List<ItemRecordResult> recent(
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "1") int pageNo)
    {
        UserInfoModel sysUser = UserTool.currentUser();
        return this.itemService.recent(pageNo,pageSize, sysUser.getId());
    }

    @SendToUser(value = {TopicEnum.TOPIC + TopicEnum.ITEM_DELETED},broadcast = false)
    @RequestMapping(value = {"/remove"}, method = {RequestMethod.POST})
    public String delete(@RequestBody @Valid ItemEditModel model) {
        if (this.itemService.deleteById(model.getId())){
            return model.getId();
        }
        return null;
    }

    @Deprecated(since = "1.0.1")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Item> search(@RequestParam String type,@RequestParam String word) {
        if (StringTool.isBlank(word)) {
            return ListTool.newArrayList();
        }
        UserInfoModel sysUser = UserTool.currentUser();
        return itemService.fullSearch(sysUser.getId(),word,type);
    }

    @Operation(description = "按条件查询" )
    @PostMapping(value = "/search2")
    public List<Item> search(@RequestBody ItemSearchCondition condition) {
        if (StringTool.isBlank(condition.getWord())) {
            return ListTool.newArrayList();
        }
        UserInfoModel sysUser = UserTool.currentUser();
        condition.setCreateUserId(sysUser.getId());
        return itemService.searchByCondition(condition);
    }



    @RequestMapping(value = {"/understood"}, method = {RequestMethod.POST})
    public boolean understood(@RequestBody ItemEditModel model) {
        return this.itemService.understood(model.getId());
    }

}
