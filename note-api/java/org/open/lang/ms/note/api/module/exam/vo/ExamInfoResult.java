package org.open.lang.ms.note.api.module.exam.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import org.soul.base.support.result.IJsonResult;
import java.util.*;

/**
 * 详情显示的数据内容
 */
@Schema(description = "测验详情数据")
public class ExamInfoResult implements IJsonResult {
    @Schema(description = "")
    private String id;
    @Schema(description = "测验标题")
    private String name;
    @Schema(description = "")
    private String createUserId;
    @Schema(description = "")
    private Date createTime;

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
}
