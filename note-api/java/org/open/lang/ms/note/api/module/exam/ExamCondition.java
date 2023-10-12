package org.open.lang.ms.note.api.module.exam;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExamCondition {

    @Schema(description = "时间范围")
    private DateRange dateRange;

    @Schema(description = "时间起")
    private Date dateStart;

    @Schema(description = "时间止")
    private Date dateEnd;

    @Schema(description = "词条类型")
    private String itemType;

    @Schema(description = "词条数量")
    private int itemCount;

    @Schema(description = "创建者")
    private String createUser;

    @Schema(description = "测验时间范围")
    public enum DateRange{
        ALL,
        TODAY,
        YESTERDAY,
        WEEK_INNER,
        WEEK_OUTER
    }


}
