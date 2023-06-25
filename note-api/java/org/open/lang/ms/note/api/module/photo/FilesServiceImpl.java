package org.open.lang.ms.note.api.module.photo;

import org.open.lang.ms.note.api.module.photo.catalogrel.FilesCatalogRelMapper;
import org.open.lang.ms.note.api.module.photo.tagrel.FilesTagRelMapper;
import org.soul.ability.data.rdb.mybatis.service.BaseCrudService;
import org.soul.base.lang.collections.CollectionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilesServiceImpl extends BaseCrudService<Files, FilesMapper, String> implements FilesService {

    @Autowired
    private FilesTagRelMapper filesTagRelMapper;

    @Autowired
    private FilesCatalogRelMapper filesCatalogRelMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(Files photo) {
        int rs = this.mapper.insert(photo);
        if (CollectionTool.isNotEmpty(photo.getTags())) {
            photo.getTags().stream().forEach(t -> t.setFileId(photo.getId()));
            filesTagRelMapper.batchInsert(photo.getTags());
        }
        if (photo.getCatalogs() != null) {
            photo.getCatalogs().setFileId(photo.getId());
            filesCatalogRelMapper.insert(photo.getCatalogs());
        }
        return rs;
    }

    @Override
    public List<Files> search(FilesCondition filesCondition) {
        return this.mapper.search(filesCondition);
    }
}
