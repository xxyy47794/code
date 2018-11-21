package com.base.system.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.common.entitiy.DeletedSupportEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用戶
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/5
 */
@Data
@TableName("sys_user")
public class User extends DeletedSupportEntity {

    public static String TYPE_ADMIN = "Admin";
    public static String TYPE_NORMAL = "Normal";
    public static String TYPE_VISITOR = "Visitor";

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("nick_name")
    private String nickName;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("pass_salt")
    private String salt;

    @TableField("user_type")
    private String userType = TYPE_NORMAL;

    @TableField("activate")
    private Boolean activate = true;

    @TableField("last_login")
    private Date lastLogin;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
