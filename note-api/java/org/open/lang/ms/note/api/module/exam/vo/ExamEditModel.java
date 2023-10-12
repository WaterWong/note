package org.open.lang.ms.note.api.module.exam.vo;
import io.swagger.v3.oas.annotations.media.Schema;

import org.soul.base.support.model.common.BaseEditModel;

/**
 * 编辑的模型vo
 */
@Schema(description = "测验编辑")
public class ExamEditModel extends BaseEditModel<String> {
    @Schema(description = "")
    private String id;
    @Schema(description = "测验标题")
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
