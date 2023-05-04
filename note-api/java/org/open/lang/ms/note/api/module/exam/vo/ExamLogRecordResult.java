package org.open.lang.ms.note.api.module.exam.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.soul.base.support.result.IJsonResult;

/**
 * 分页查询结果列表数据
 */
@ApiModel(value = "测验日志列表行数据")
public class ExamLogRecordResult implements IJsonResult {
    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "")
    private String examId;
    @ApiModelProperty(value = "")
    private String itemId;
    @ApiModelProperty(value = "詞條数量")
    private Boolean result;

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
    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
