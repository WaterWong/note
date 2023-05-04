package org.open.lang.ms.note.api.module.exam.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.soul.base.support.model.common.BaseEditModel;

/**
 * 编辑的模型vo
 */
@ApiModel(value = "测验编辑")
public class ExamEditModel extends BaseEditModel<String> {
    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "测验标题")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
