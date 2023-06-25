package org.open.lang.ms.note.api.module.photo.tagrel;

import org.apache.ibatis.annotations.Mapper;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FilesTagRelMapper extends IBaseCrudMapper<FilesTagRel, String> {

}
