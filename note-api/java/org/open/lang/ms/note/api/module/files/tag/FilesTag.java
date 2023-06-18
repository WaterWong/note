package org.open.lang.ms.note.api.module.files.tag;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.bean.IEntity;
import org.soul.base.support.model.common.BaseIdModel;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@TableName("files_tag")
public class FilesTag extends BaseIdModel<Long> {


    public static final String DESC = "desc";

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @NotEmpty(message = "不能为空")
    private String desc;


}
