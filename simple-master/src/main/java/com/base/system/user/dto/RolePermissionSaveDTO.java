package com.base.system.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class RolePermissionSaveDTO {

    private Long roleId;

    private List<Long> permissions;

}
