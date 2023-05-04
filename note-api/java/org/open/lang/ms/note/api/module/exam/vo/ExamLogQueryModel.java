package org.open.lang.ms.note.api.module.exam.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.soul.base.support.model.common.BasePagingModel;

/**
 * 分页查询对象
 */
@ApiModel(value = "测验日志列表查询对象")
public class ExamLogQueryModel extends BasePagingModel {
    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "")
    private String examId;
    @ApiModelProperty(value = "")
    private String itemId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
