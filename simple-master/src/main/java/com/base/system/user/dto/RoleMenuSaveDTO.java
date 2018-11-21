package com.base.system.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleMenuSaveDTO {

    private Long roleId;

    private List<Long> menus;

}
