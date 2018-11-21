package com.base.system.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.common.entitiy.DeletedSupportEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/15
 */
@Data
@TableName("sys_role")
public class Role extends DeletedSupportEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("role_describe")
    private String roleDescribe;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
