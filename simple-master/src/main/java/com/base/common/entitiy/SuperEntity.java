package com.base.common.entitiy;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/5
 */
@Data
public abstract class SuperEntity extends Model<SuperEntity>{

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private Integer version = 1;

    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;

    @TableField(value = "modify_by",fill = FieldFill.INSERT_UPDATE)
    private String modifyBy;
}
