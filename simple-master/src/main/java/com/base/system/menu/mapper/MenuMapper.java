package com.base.system.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.base.system.menu.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {


    String selectPathByKey(@Param("key") String key);

    Menu selectByPathKey(@Param("key") String key);

    List<Menu> selectAllMenu();

    List<Menu> selectByRole(@Param("roleId") Long roleId);

    List<Long> selectIdByRole(@Param("roleId") Long roleId);

    Integer saveMenuInRole(@Param("roleId") Long roleId, @Param("menus") List<Long> menus);

    Integer deleteMenuInRole(@Param("roleId") Long roleId);
}
