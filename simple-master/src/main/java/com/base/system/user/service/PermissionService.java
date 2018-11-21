package com.base.system.user.service;

import com.base.system.user.dto.RolePermissionSaveDTO;
import com.base.system.user.entity.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> getMenuPermission(Long menuId);

    Integer saveRolePermission(RolePermissionSaveDTO request);
}
