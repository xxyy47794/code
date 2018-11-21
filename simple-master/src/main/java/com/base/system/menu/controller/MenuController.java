package com.base.system.menu.controller;

import com.base.common.entitiy.ResponseModel;
import com.base.common.exception.SimpleException;
import com.base.system.menu.entity.Menu;
import com.base.system.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("key/{path}")
    public ResponseModel path(@PathVariable("path") String key){

        Menu menu = menuService.getByPathKey(key);
        if(menu == null){
            throw new SimpleException("找不到此菜单");
        }
        return new ResponseModel(menu);
    }

    @PostMapping("all")
    public ResponseModel getAllMenu(){
        return new ResponseModel(menuService.getAllMenu());
    }

    @PostMapping("tree")
    public ResponseModel getMenuTree(){
        return new ResponseModel(menuService.getMenuTree());
    }

}
