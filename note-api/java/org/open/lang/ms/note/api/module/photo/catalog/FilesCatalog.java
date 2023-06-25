package org.open.lang.ms.note.api.module.photo.catalog;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.bean.IEntity;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@TableName("files_catalog")
public class FilesCatalog implements IEntity<String> {


    public static final String DESC = "desc";

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @NotEmpty(message = "不能为空")
    private String desc;


}
