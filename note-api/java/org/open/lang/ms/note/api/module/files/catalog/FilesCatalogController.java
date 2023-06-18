package org.open.lang.ms.note.api.module.files.catalog;

import io.swagger.annotations.Api;
import org.open.lang.ms.note.api.module.files.tag.FilesTag;
import org.open.lang.ms.note.base.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我的
 */
@RestController
@RequestMapping(value = "/files/catalog")
@Api(tags = "文件分类")
public class FilesCatalogController extends BaseCrudController<Long, FilesCatalogService, FilesCatalog> {


}
