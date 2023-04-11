package org.open.lang.ms.note.api.module.items.favorite;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.model.common.BaseEditModel;

/**
 * 编辑的模型vo
 */
@ApiModel(value = "視圖:詞條-收藏夾 编辑")
@Setter
@Getter
public class ItemFavoriteEditModel extends BaseEditModel<String> {

    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "")
    private String id;

    private String itemId;


}
