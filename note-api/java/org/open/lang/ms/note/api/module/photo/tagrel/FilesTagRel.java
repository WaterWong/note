package org.open.lang.ms.note.api.module.photo.tagrel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.bean.IEntity;

@Getter
@Setter
@TableName("files_tag_rel")
public class FilesTagRel implements IEntity<String> {


    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private Long fileTagId;

    private String fileId;

}
