package org.open.lang.ms.note.api.module.photo;

import lombok.Getter;
import lombok.Setter;
import org.soul.base.support.result.IJsonResult;

/**
 * 分页查询结果列表数据
 */
@Setter
@Getter
public class FilesRecordResult implements IJsonResult {
    private String id;

    private String path;

    private String hash;

}
