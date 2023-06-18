package org.open.lang.ms.note.api.module.files;

import io.swagger.annotations.Api;
import org.open.lang.ms.note.base.BaseCrudController;
import org.soul.base.bean.Pair;
import org.soul.base.query.result.Paging;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文件
 */
@RestController
@RequestMapping(value = "/files")
@Api(tags = "文件")
public class FilesController extends BaseCrudController<String, FilesService, Files> {

    @RequestMapping("/list")
    List<Files> list( @RequestBody  FilesCondition filesCondition) {
        return biz.search(filesCondition);
    }
}
