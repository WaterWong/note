package org.open.lang.ms.note.api.module.files.tag;

import io.swagger.annotations.Api;
import org.open.lang.ms.note.api.module.files.catalog.FilesCatalog;
import org.open.lang.ms.note.base.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文件标签
 */
@RestController
@RequestMapping(value = "/files/tag")
@Api(tags = "文件标签")
public class FilesTagController extends BaseCrudController<String, FilesTagService, FilesTag> {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<FilesTag> all() {
        return biz.allSearch();
    }
}
