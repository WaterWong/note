package org.open.lang.ms.note.api.module.photo.tag;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.open.lang.ms.note.base.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文件标签
 */
@RestController
@RequestMapping("/photo/tag")
@Tag(name = "文件标签",description = "文件标签管理")
public class FilesTagController extends BaseCrudController<String, FilesTagService, FilesTag> {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<FilesTag> all() {
        return biz.allSearch();
    }
}
