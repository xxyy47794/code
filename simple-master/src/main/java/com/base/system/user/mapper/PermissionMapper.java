package com.base.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.base.system.user.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectByMenu(@Param("menuId") Long menuId);

    Integer deleteDefaultPermissionInRole(@Param("roleId") Long roleId);

    Integer savePermissionInRole(@Param("roleId") Long roleId, @Param("permissions") List<Long> permissions);

    List<Long> selectDefaultByMenu(@Param("menus") List<Long> menus);

    Integer deletePermissionInRole(@Param("roleId") Long roleId);

    List<Long> selectByRole(@Param("roleId") Long roleId);
}
