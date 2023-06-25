package org.open.lang.ms.note.api.module.photo.catalogrel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.bean.IEntity;

@Getter
@Setter
@TableName("files_catalog_rel")
public class FilesCatalogRel implements IEntity<String> {


    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private Long fileCatalogId;

    private String fileId;

}
