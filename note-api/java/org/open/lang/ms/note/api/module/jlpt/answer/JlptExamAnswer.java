package org.open.lang.ms.note.api.module.jlpt.answer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;

import java.io.Serial;

@Schema(description = "JLPT正确答案配置")
@TableName("jlpt_exam_answer")
@Getter
@Setter
public class JlptExamAnswer extends BaseEntity<String> {

    @Serial
    private static final long serialVersionUID = 1772295976656466171L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "JLPT等级")
    private String level;

    @Schema(description = "考试年月, 格式 yyyy07 或 yyyy12")
    private String examYm;

    @Schema(description = "考试内容")
    private String sectionType;

    @Schema(description = "番号")
    private Integer questionNo;

    @Schema(description = "正确答案")
    private String correctAnswer;
}
