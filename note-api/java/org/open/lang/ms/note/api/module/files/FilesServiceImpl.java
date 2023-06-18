package org.open.lang.ms.note.api.module.files;

import org.open.lang.ms.note.api.module.files.catalogrel.FilesCatalogRelMapper;
import org.open.lang.ms.note.api.module.files.tagrel.FilesTagRelMapper;
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
    public int insert(Files files) {
        int rs = this.mapper.insert(files);
        if (CollectionTool.isNotEmpty(files.getTags())) {
            files.getTags().stream().forEach(t -> t.setFileId(files.getId()));
            filesTagRelMapper.batchInsert(files.getTags());
        }
        if (CollectionTool.isNotEmpty(files.getTags())) {
            files.getCatalogs().stream().forEach(t -> t.setFileId(files.getId()));
            filesCatalogRelMapper.batchInsert(files.getCatalogs());
        }
        return rs;
    }

    @Override
    public List<Files> search(FilesCondition filesCondition) {
        return this.mapper.search(filesCondition);
    }
}
