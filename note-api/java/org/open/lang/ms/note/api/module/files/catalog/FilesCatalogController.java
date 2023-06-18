package org.open.lang.ms.note.api.module.files.catalog;

import io.swagger.annotations.Api;
import org.open.lang.ms.note.api.module.files.catalogrel.FilesCatalogRel;
import org.open.lang.ms.note.api.module.files.tag.FilesTag;
import org.open.lang.ms.note.base.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文件分类
 */
@RestController
@RequestMapping(value = "/files/catalog")
@Api(tags = "文件分类")
public class FilesCatalogController extends BaseCrudController<String, FilesCatalogService, FilesCatalog> {


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<FilesCatalog> all() {
        return biz.allSearch();
    }

}
