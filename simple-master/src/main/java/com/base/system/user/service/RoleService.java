package com.base.system.user.service;

import com.base.common.dto.IdNameDTO;
import com.base.common.table.entity.TableRequest;
import com.base.common.table.entity.TableResponse;
import com.base.system.menu.entity.Menu;
import com.base.system.user.dto.MenuPermissionDTO;
import com.base.system.user.dto.RoleDTO;
import com.base.system.user.dto.RoleMenuSaveDTO;
import com.base.system.user.entity.Role;

import java.util.List;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/15
 */
public interface RoleService {

    TableResponse getRoleTable(TableRequest request);

    List<Role> getRoleList();

    Integer addRole(RoleDTO role);

    Role saveRole(Role role);

    Integer deleteRole(Long id);

    Boolean checkName(IdNameDTO dto);

    List<Long> getRoleMenu(Long roleId);

    Integer saveRoleMenu(RoleMenuSaveDTO request);

    MenuPermissionDTO getMenuAndPermission(Long roleId);
}
