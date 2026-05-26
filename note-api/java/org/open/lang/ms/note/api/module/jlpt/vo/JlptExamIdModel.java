package org.open.lang.ms.note.api.module.jlpt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JlptExamIdModel {

    @Schema(description = "考试ID")
    private String id;
}
