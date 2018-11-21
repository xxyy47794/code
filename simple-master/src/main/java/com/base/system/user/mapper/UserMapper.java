package com.base.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.system.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/5
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{

    User selectByName(@Param("name") String name);

    Integer deleteByName(@Param("name") String name);

    IPage<User> selectAll(Page<User> page);
}
