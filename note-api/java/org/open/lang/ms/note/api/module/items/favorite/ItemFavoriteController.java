package org.open.lang.ms.note.api.module.items.favorite;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.open.lang.ms.note.api.module.passport.UserTool;
import org.soul.base.bean.BeanTool;
import org.soul.base.lang.collections.CollectionTool;
import org.soul.base.lang.collections.ListTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 視圖:詞條-收藏夾 增删改查
 */
@RestController
@RequestMapping(value = "/item/favorite")
@Tag(name = "視圖:詞條-收藏夾 ")
public class ItemFavoriteController {

    @Autowired
    private ItemFavoriteService itemFavoriteService;

    /**
     *
     * @param editModel
     * @return
     */
    @RequestMapping(value = "/star", method = RequestMethod.POST)
    public Boolean star(@RequestBody ItemFavoriteEditModel editModel) {
        String userId = UserTool.currentUser().getId();
        List<ItemFavorite> itemFavorites = itemFavoriteService.searchByItemIdByCreateUser(ListTool.newArrayList(editModel.getItemId()), userId);
        if (CollectionTool.isNotEmpty(itemFavorites)) {
            //cancel star
            return itemFavoriteService.delete(itemFavorites.get(0));
        }
        //add star
        ItemFavorite itemFavorite = new ItemFavorite();
        BeanTool.copyProperties(editModel,itemFavorite);
        return itemFavoriteService.insert(itemFavorite) > 0;
    }
}
