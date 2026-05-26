package org.open.lang.ms.note.api.module.jlpt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.open.lang.ms.note.api.module.jlpt.record.JlptExamRecord;

import java.util.List;

@Getter
@Setter
public class JlptExamFinishModel extends JlptExamIdModel {

    @Schema(description = "本次考试作答记录")
    private List<JlptExamRecord> records;
}
