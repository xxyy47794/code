package com.base.system.user.controller;

import com.base.common.entitiy.ResponseModel;
import com.base.system.user.dto.RolePermissionSaveDTO;
import com.base.system.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("per")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 获得菜单下权限
     * @param menuId
     * @return
     */
    @PostMapping("getMenuPermission/{menuId}")
    public ResponseModel getMenuPermission(@PathVariable Long menuId){
        return new ResponseModel(permissionService.getMenuPermission(menuId));
    }

    /**
     * 保存角色菜单
     * @param request
     * @return
     */
    @PostMapping("saveRolePermission")
    public ResponseModel saveRolePermission(@RequestBody RolePermissionSaveDTO request){
        return new ResponseModel(permissionService.saveRolePermission(request));
    }

}
