package org.open.lang.ms.note.api.module.my;

import org.soul.ability.data.rdb.mybatis.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class SysUserExtServiceImpl extends BaseCrudService<SysUserExt, SysUserExtMapper, String> implements SysUserExtService {

    @Override
    public int insertOrUpdate(SysUserExt addVo) {
        SysUserExt ext = this.mapper.get(addVo.getId());
        if (ext != null) {
            ext.setAvatar(addVo.getAvatar());
            this.mapper.updateOnly(addVo, SysUserExt.AVATAR);
            return 1;
        } else {
            return this.mapper.insert(addVo);
        }
    }
}
