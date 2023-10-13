package org.open.lang.ms.note.api.module.items.item;


import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Roger
 */
@Schema(description = "词条内容字段枚举")
public enum ItemFieldRange {

    @Schema(description = "所有字段")
    ALL,

    @Schema(description = "日文字段")
    JAPANESE,

    @Schema(description = "平假字段")
    HIRAGANA,

    @Schema(description = "中文字段")
    CHINESE,
    ;
}
