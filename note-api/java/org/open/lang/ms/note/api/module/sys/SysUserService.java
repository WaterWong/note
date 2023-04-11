package org.open.lang.ms.note.api.module.sys;


public interface SysUserService {

    SysUser signUp(SysUser sysUser);

    SysUser get(String username);
}
