package com.base.common.entitiy;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/5
 */
@Data
public abstract class DeletedSupportEntity extends SuperEntity{

    @TableLogic
    @TableField("deleted")
    private Integer deleted = 0;
}
