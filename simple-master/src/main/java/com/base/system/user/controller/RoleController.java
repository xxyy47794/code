package com.base.system.user.controller;

import com.base.common.dto.IdNameDTO;
import com.base.common.entitiy.ResponseModel;
import com.base.common.table.entity.TableRequest;
import com.base.system.user.dto.RoleDTO;
import com.base.system.user.dto.RoleMenuSaveDTO;
import com.base.system.user.entity.Role;
import com.base.system.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/15
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 角色列表
     * @param request
     * @return
     */
    @PostMapping("table")
    public ResponseModel getRoleTable(@RequestBody TableRequest request){
        return new ResponseModel(roleService.getRoleTable(request));
    }

    /**
     * 角色数据
     * @return
     */
    @PostMapping("all")
    public ResponseModel getRoleAll(){
        return new ResponseModel(roleService.getRoleList());
    }

    /**
     * 新建角色
     * @return
     */
    @PostMapping("add")
    public ResponseModel addRole(@RequestBody RoleDTO role){
        return new ResponseModel(roleService.addRole(role));
    }

    /**
     * 编辑角色
     * @param role
     * @return
     */
    @PostMapping("save")
    public ResponseModel saveRole(@RequestBody Role role){
        return new ResponseModel(roleService.saveRole(role));
    }

    /**
     * 删除角色
     * @return
     */
    @GetMapping("delete/{id}")
    public ResponseModel deleteRole(@PathVariable Long id){
        return new ResponseModel(roleService.deleteRole(id));
    }

    /**
     * 检查名称唯一性
     * @return
     */
    @PostMapping("nameCheck")
    public ResponseModel checkName(@RequestBody IdNameDTO dto){
        return new ResponseModel(roleService.checkName(dto));
    }

    /**
     * 获取角色拥有菜单和权限
     * @param roleId
     * @return
     */
    @PostMapping("getMenuAndPermission/{roleId}")
    public ResponseModel getMenuAndPermission(@PathVariable Long roleId){
        return new ResponseModel(roleService.getMenuAndPermission(roleId));
    }

    /**
     * 保存角色菜单
     * @param request
     * @return
     */
    @PostMapping("saveRoleMenu")
    public ResponseModel saveRoleMenu(@RequestBody RoleMenuSaveDTO request){
        return new ResponseModel(roleService.saveRoleMenu(request));
    }

}
