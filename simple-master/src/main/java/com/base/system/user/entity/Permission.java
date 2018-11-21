package com.base.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.common.entitiy.SuperEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 权限
 */
@Data
@TableName("sys_permission")
public class Permission extends SuperEntity{

    @TableId(value = "id")
    private Long id;

    @TableField("name")
    private String name;

    @TableField("url")
    private String url;

    @TableField("url_type")
    private String urlType;

    @TableField("hided")
    private Boolean hided;

    @TableField("menu_id")
    private Long menuId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
