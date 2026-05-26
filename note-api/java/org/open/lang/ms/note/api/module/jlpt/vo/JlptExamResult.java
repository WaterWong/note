package org.open.lang.ms.note.api.module.jlpt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.open.lang.ms.note.api.module.jlpt.JlptExam;
import org.open.lang.ms.note.api.module.jlpt.record.JlptExamRecord;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class JlptExamResult {

    @Schema(description = "考试主记录")
    private JlptExam exam;

    @Schema(description = "作答记录")
    private List<JlptExamRecord> records;

    @Schema(description = "番号数")
    private Integer questionCount;

    @Schema(description = "疑问数")
    private Integer doubtCount;

    @Schema(description = "正确数")
    private Integer correctCount;

    @Schema(description = "错误数")
    private Integer errorCount;

    @Schema(description = "正确率")
    private BigDecimal correctRate;
}
