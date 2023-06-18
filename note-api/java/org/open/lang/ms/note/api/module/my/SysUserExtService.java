package org.open.lang.ms.note.api.module.my;

import org.soul.base.support.service.IBaseCrudService;

public interface SysUserExtService extends IBaseCrudService<SysUserExt, String> {


    int insertOrUpdate(SysUserExt addVo);
}
