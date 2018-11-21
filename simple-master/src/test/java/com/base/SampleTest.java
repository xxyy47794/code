package com.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.system.user.entity.User;
import com.base.system.user.mapper.UserMapper;
import com.base.system.user.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void saveUser(){
//        userService.saveUser();
//        User user = userService.selectOneByName("adm");
    }

    @Test
    public void selectUser(){
        userService.updateUser();
    }

    @Test
    public void selectAll(){
        IPage<User> list = userService.selectAll();
    }

    @Test
    public void updateUser(){
        userService.updateUser();
    }

    @Test
    public void deletedUser(){
        Integer i = userService.deletedOne(2L);
    }

}
