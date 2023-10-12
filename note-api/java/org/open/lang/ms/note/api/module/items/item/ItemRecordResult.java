package org.open.lang.ms.note.api.module.items.item;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.result.IJsonResult;
import java.util.*;

/**
 * 分页查询结果列表数据
 */
@Setter
@Getter
@Schema(description = "詞條列表行数据")
public class ItemRecordResult implements IJsonResult {
    @Schema(description = "")
    private String id;
    @Schema(description = "詞條類型: 1=單詞, 2=句子")
    private String type;
    /**
     * 读音(位置)
     */
    private int soundPosition;
    @Schema(description = "日文")
    private String japanese;
    @Schema(description = "假名")
    private String hiragana;
    @Schema(description = "中文")
    private String chinese;
    @Schema(description = "")
    private String createUserId;
    @Schema(description = "")
    private String createUser;
    @Schema(description = "")
    private Date createTime;

    /**
     * 是否:收藏
     */
    private boolean isFavorite = false;

    /**
     * 是否:懂了(掌握了,免测试)
     */
    private Boolean isUnderstood;

}
