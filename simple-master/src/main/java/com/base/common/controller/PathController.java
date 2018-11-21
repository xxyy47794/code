package com.base.common.controller;

import com.base.system.menu.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PathController {

    @Autowired
    private MenuMapper menuMapper;

    @GetMapping({"","login"})
    public String login(){
        return "login";
    }

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("home/home")
    public String path(){
        return "home/home";
    }

    @GetMapping("page/{key}")
    public String getPage(@PathVariable("key") String key){
        return menuMapper.selectPathByKey(key);
    }

}
