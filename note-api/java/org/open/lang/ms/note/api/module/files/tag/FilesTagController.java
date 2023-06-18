package org.open.lang.ms.note.api.module.files.tag;

import io.swagger.annotations.Api;
import org.open.lang.ms.note.api.module.files.catalog.FilesCatalog;
import org.open.lang.ms.note.api.module.files.catalog.FilesCatalogService;
import org.open.lang.ms.note.base.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我的
 */
@RestController
@RequestMapping(value = "/files/tag")
@Api(tags = "文件标签")
public class FilesTagController extends BaseCrudController<Long, FilesTagService, FilesTag> {


}
