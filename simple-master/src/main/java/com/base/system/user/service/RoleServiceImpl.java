package com.base.system.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.common.dto.IdNameDTO;
import com.base.common.table.entity.TableRequest;
import com.base.common.table.entity.TableResponse;
import com.base.common.table.util.TableUtil;
import com.base.system.menu.mapper.MenuMapper;
import com.base.system.user.dto.MenuPermissionDTO;
import com.base.system.user.dto.RoleDTO;
import com.base.system.user.dto.RoleMenuSaveDTO;
import com.base.system.user.entity.Permission;
import com.base.system.user.entity.Role;
import com.base.system.user.mapper.PermissionMapper;
import com.base.system.user.mapper.RoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/15
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public TableResponse getRoleTable(TableRequest request) {
        Page<Role> page = TableUtil.buildPageRequest(request.getPage());
        IPage<Role> result = roleMapper.selectAll(page);
        return TableUtil.buildPageResponse(result);
    }

    @Override
    public List<Role> getRoleList() {
        return roleMapper.selectAll();
    }

    @Override
    public Integer addRole(RoleDTO dto) {

        Role role = new Role();
        role.setName(dto.getName());
        role.setRoleDescribe(dto.getRoleDescribe());

        return roleMapper.insert(role);
    }

    @Override
    @Transactional
    public Role saveRole(Role role) {
        Long id = role.getId();
        if(id != null){
            Role dbRole = roleMapper.selectById(id);
            if(dbRole != null){
                BeanUtils.copyProperties(role,dbRole);
                roleMapper.updateById(dbRole);
                return dbRole;
            }
        }
        return null;
    }

    @Override
    public Integer deleteRole(Long id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public Boolean checkName(IdNameDTO dto) {

        Long id = dto.getId();
        String name = dto.getName();

        Role role;
        if(id != null){
            role = roleMapper.selectById(id);
            if(!StringUtils.isEmpty(name) && name.equals(role.getName())){
                return true;
            }
        }
        role = roleMapper.selectByName(name);
        if(role != null){
            return false;
        }
        return true;
    }

    @Override
    public List<Long> getRoleMenu(Long roleId) {
        return menuMapper.selectIdByRole(roleId);
    }

    @Override
    @Transactional
    public Integer saveRoleMenu(RoleMenuSaveDTO request) {

        Long roleId = request.getRoleId();
        List<Long> menus = request.getMenus();

        //删除原有菜单记录
        menuMapper.deleteMenuInRole(roleId);

        //删除默认菜单权限
        permissionMapper.deleteDefaultPermissionInRole(roleId);

        if(CollectionUtils.isEmpty(menus)){
            return 0;
        }
        //查找默认菜单权限
        List<Long> defaultPerminssion = permissionMapper.selectDefaultByMenu(menus);
        //添加默认菜单权限
        permissionMapper.savePermissionInRole(roleId,defaultPerminssion);
        //添加角色菜单
        menuMapper.saveMenuInRole(roleId,menus);
        return 1;
    }

    @Override
    public MenuPermissionDTO getMenuAndPermission(Long roleId) {

        MenuPermissionDTO dto = new MenuPermissionDTO();
        dto.setRoleId(roleId);
        dto.setMenus(menuMapper.selectIdByRole(roleId));
        dto.setPermissions(permissionMapper.selectByRole(roleId));

        return dto;
    }
}
