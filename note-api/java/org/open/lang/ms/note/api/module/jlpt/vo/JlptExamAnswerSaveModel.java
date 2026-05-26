package org.open.lang.ms.note.api.module.jlpt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.open.lang.ms.note.api.module.jlpt.answer.JlptExamAnswer;

import java.util.List;

@Getter
@Setter
public class JlptExamAnswerSaveModel extends JlptExamCondition {

    @Schema(description = "正确答案列表")
    private List<JlptExamAnswer> answers;
}
