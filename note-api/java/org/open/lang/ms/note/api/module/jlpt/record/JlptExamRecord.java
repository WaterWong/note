package org.open.lang.ms.note.api.module.jlpt.record;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;

import java.io.Serial;

@Schema(description = "JLPT考试作答记录")
@TableName("jlpt_exam_record")
@Getter
@Setter
public class JlptExamRecord extends BaseEntity<String> {

    @Serial
    private static final long serialVersionUID = 2557909482802231209L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "考试ID")
    private String examId;

    @Schema(description = "考试内容")
    private String sectionType;

    @Schema(description = "番号")
    private Integer questionNo;

    @Schema(description = "疑问: n=无, y=有")
    private String doubtFlag;

    @Schema(description = "作答")
    private String userAnswer;

    @Schema(description = "正确答案")
    private String correctAnswer;

    @Schema(description = "是否正确")
    private Boolean result;
}
