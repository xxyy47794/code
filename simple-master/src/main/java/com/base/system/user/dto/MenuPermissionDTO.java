package com.base.system.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuPermissionDTO {

    private Long roleId;

    private List<Long> menus;

    private List<Long> permissions;

}
