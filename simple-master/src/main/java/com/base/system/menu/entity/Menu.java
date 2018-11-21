package com.base.system.menu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.common.entitiy.DeletedSupportEntity;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_menu")
public class Menu extends DeletedSupportEntity{

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("path_key")
    private String pathKey;

    @TableField("path")
    private String path;

    @TableField("icon")
    private String icon;

    @TableField("hide")
    private Boolean hide;

    @TableField("parent_id")
    private Long parentId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
