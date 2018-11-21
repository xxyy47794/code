package com.base.system.user.service;

import com.base.system.user.dto.RolePermissionSaveDTO;
import com.base.system.user.entity.Permission;
import com.base.system.user.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<Permission> getMenuPermission(Long menuId) {
        return permissionMapper.selectByMenu(menuId);
    }

    @Override
    @Transactional
    public Integer saveRolePermission(RolePermissionSaveDTO request) {

        Long roleId = request.getRoleId();
        List<Long> permissions = request.getPermissions();

        //删除原有非默认权限
        permissionMapper.deletePermissionInRole(roleId);

        if(CollectionUtils.isEmpty(permissions)){
            return 0;
        }
        permissionMapper.savePermissionInRole(roleId,permissions);
        return 1;
    }
}
