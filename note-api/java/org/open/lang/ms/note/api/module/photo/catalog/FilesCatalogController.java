package org.open.lang.ms.note.api.module.photo.catalog;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.open.lang.ms.note.base.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文件分类
 */
@RestController
@RequestMapping(value = "/photo/catalog")
@Tag(name = "文件分类")
public class FilesCatalogController extends BaseCrudController<String, FilesCatalogService, FilesCatalog> {


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<FilesCatalog> all() {
        return biz.allSearch();
    }

}
