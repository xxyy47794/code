package com.base.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.system.user.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/15
 */
public interface RoleMapper extends BaseMapper<Role> {

    IPage<Role> selectAll(Page<Role> page);

    List<Role> selectAll();

    Role selectByName(@Param("name") String name);
}
