package org.open.lang.ms.note.api.module.items.favorite;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.model.common.BaseEditModel;

/**
 * 编辑的模型vo
 */
@Schema(description = "視圖:詞條-收藏夾 编辑")
@Setter
@Getter
public class ItemFavoriteEditModel extends BaseEditModel<String> {

    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "")
    private String id;

    private String itemId;


}
