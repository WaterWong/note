package org.open.lang.ms.note.api.module.photo;

import org.soul.base.support.service.IBaseCrudService;

import java.util.List;

public interface FilesService extends IBaseCrudService<Files, String> {

    List<Files> search(FilesCondition filesCondition);
}
