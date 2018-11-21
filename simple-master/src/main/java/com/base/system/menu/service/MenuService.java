package com.base.system.menu.service;

import com.base.common.entitiy.TreeNode;
import com.base.system.menu.entity.Menu;

import java.util.List;

public interface MenuService {

    Menu getByPathKey(String key);

    List<Menu> getAllMenu();

    List<TreeNode> getMenuTree();
}
