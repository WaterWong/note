package org.open.lang.ms.note.api.module.exam.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import org.soul.base.bean.validation.constraint.annotaions.Compare;
import org.soul.base.support.logic.LogicOperatorEnum;
import org.soul.base.support.model.common.BasePagingModel;
import java.util.*;

/**
 * 分页查询对象
 */
@Schema(description = "测验列表查询对象")
public class ExamQueryModel extends BasePagingModel {
    @Schema(description = "")
    private String id;
    @Schema(description = "")
    private String createUserId;
    @Schema(description = "")
    private Date createTime;
    @Schema(description = " 开始时间")
    private Date createTimeStart;
    @Schema(description = " 结束时间")
    private Date createTimeEnd;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Compare(message = "开始时间要大于等于结束时间", logic = LogicOperatorEnum.GE, anotherProperty = "createTimeEnd")
    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    @Compare(message = "结束时间要大于等于开始时间", logic = LogicOperatorEnum.GE, anotherProperty = "createTimeStart")
    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
