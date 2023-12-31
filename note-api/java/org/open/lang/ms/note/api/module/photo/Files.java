package org.open.lang.ms.note.api.module.photo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.open.lang.ms.note.api.module.photo.catalogrel.FilesCatalogRel;
import org.open.lang.ms.note.api.module.photo.tagrel.FilesTagRel;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;

import java.util.List;

@Getter
@Setter
@TableName("files")
public class Files extends BaseEntity<String> {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String path;

    private String hash;


    @TableField(exist = false)
    private List<FilesTagRel> tags;

    @TableField(exist = false)
    private FilesCatalogRel catalogs;

}
