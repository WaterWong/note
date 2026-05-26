package org.open.lang.ms.note.api.module.jlpt;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;

import java.io.Serial;
import java.util.Date;

@Schema(description = "JLPT考试")
@TableName("jlpt_exam")
@Getter
@Setter
public class JlptExam extends BaseEntity<String> {

    @Serial
    private static final long serialVersionUID = 3463157156610926001L;

    public static final String FIELD_STATUS = "status";
    public static final String FIELD_PAUSE_TIME = "pauseTime";
    public static final String FIELD_FINISH_TIME = "finishTime";

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "JLPT等级")
    private String level;

    @Schema(description = "考试年月, 格式 yyyy07 或 yyyy12")
    private String examYm;

    @Schema(description = "考试状态: RUNNING, PAUSED, FINISHED")
    private String status;

    @Schema(description = "开始时间")
    private Date startTime;

    @Schema(description = "暂停时间")
    private Date pauseTime;

    @Schema(description = "结束时间")
    private Date finishTime;
}
