package org.open.lang.ms.note.api.module.photo;

import org.apache.ibatis.annotations.Mapper;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FilesMapper extends IBaseCrudMapper<Files, String> {

    List<Files> search(FilesCondition filesCondition);

}
