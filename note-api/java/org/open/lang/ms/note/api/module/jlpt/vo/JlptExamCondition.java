package org.open.lang.ms.note.api.module.jlpt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JlptExamCondition {

    @Schema(description = "JLPT等级")
    private String level;

    @Schema(description = "考试年月, 格式 yyyy07 或 yyyy12")
    private String examYm;

    @Schema(description = "创建人ID")
    private String createUserId;
}
