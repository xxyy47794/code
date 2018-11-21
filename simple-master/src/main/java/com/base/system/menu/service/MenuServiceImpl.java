package com.base.system.menu.service;

import com.base.common.entitiy.TreeNode;
import com.base.common.util.TreeUtil;
import com.base.system.menu.entity.Menu;
import com.base.system.menu.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu getByPathKey(String key) {
        return menuMapper.selectByPathKey(key);
    }

    @Override
    public List<Menu> getAllMenu() {
        return menuMapper.selectAllMenu();
    }

    @Override
    public List<TreeNode> getMenuTree() {

        List<Menu> menus = menuMapper.selectAllMenu();
        List<TreeNode> nodes = new ArrayList<>();

        if(CollectionUtils.isEmpty(menus)){
            return nodes;
        }
        for(Menu menu : menus){

            HashMap<String,Object> map = new HashMap<>();
            map.put("path",menu.getPath());
            map.put("icon",menu.getIcon());

            if(menu.getParentId() != null){
                nodes.add(new TreeNode(menu.getPathKey(),menu.getId(),menu.getName(),menu.getParentId()).buildData(map));
            }else {
                nodes.add(new TreeNode(menu.getPathKey(),menu.getId(),menu.getName()).buildData(map));
            }
        }
        return TreeUtil.buildTree(nodes);
    }
}
