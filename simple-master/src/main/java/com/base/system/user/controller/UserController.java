package com.base.system.user.controller;

import com.base.common.dto.IdNameDTO;
import com.base.common.entitiy.ResponseModel;
import com.base.common.table.entity.TableRequest;
import com.base.system.user.dto.UserDTO;
import com.base.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/5
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获得用户列表
     * @param request
     * @return
     */
    @PostMapping("table")
    public ResponseModel getUserTable(@RequestBody TableRequest request){
        return new ResponseModel(userService.getUserTable(request));
    }

    /**
     * 用戶詳情
     * @param id
     * @return
     */
    @GetMapping("info/{id}")
    public ResponseModel getUserInfo(@PathVariable Long id){
        return new ResponseModel(userService.getUserInfo(id));
    }

    /**
     * 删除用户（逻辑删除）
     * @param id
     * @return
     */
    @GetMapping("deleted/{id}")
    public ResponseModel deletedUserInfo(@PathVariable Long id){
        return new ResponseModel(userService.deletedOne(id));
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("save")
    public ResponseModel saveUserInfo(@RequestBody UserDTO user){
        return new ResponseModel(userService.saveUser(user));
    }

    /**
     * 用户名唯一性验证
     * @param request
     * @return
     */
    @PostMapping("usernameCheck")
    public ResponseModel checkUserName(@RequestBody IdNameDTO request){
        return new ResponseModel(userService.checkUserName(request));
    }
}
