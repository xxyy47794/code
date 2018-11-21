package com.base.system.auth.controller;

import com.base.common.entitiy.ResponseModel;
import com.base.common.exception.SimpleException;
import com.base.common.exception.UnAuthException;
import com.base.common.util.AuthUtil;
import com.base.system.auth.entity.NamePasswordToken;
import com.base.system.user.entity.User;
import com.base.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class LoginController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("login")
    public ResponseModel login(@RequestBody NamePasswordToken token){

        String username = token.getUsername();
        String password = token.getPassword();

        User user = userMapper.selectByName(username);

        if(user != null && user.getPassword().equals(password)){

            if(user.getActivate()){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
            } else {
                throw new UnAuthException("用户已被禁用");
            }

        } else {
            throw new UnAuthException("用户名或者密码错误");
        }
        return new ResponseModel();
    }

    @GetMapping("logout")
    public ResponseModel logout(){

        AuthUtil.removeCurrentUser();

        return new ResponseModel();
    }

}
