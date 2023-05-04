package org.open.lang.ms.note.api.module.exam.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.soul.base.support.model.common.BaseEditModel;

/**
 * 编辑的模型vo
 */
@ApiModel(value = "测验日志编辑")
public class ExamLogEditModel extends BaseEditModel<String> {
    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "")
    private String examId;
    @ApiModelProperty(value = "")
    private String itemId;
    @ApiModelProperty(value = "詞條数量")
    private Boolean result;
    @ApiModelProperty(value = "原文")
    private String origin;
    @ApiModelProperty(value = "译文")
    private String translate;
    @ApiModelProperty(value = "答案")
    private String answer;

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
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
