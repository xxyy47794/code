package com.base.system.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.common.dto.IdNameDTO;
import com.base.common.table.entity.TableRequest;
import com.base.common.table.entity.TableResponse;
import com.base.common.table.util.TableUtil;
import com.base.system.user.dto.UserDTO;
import com.base.system.user.entity.User;
import com.base.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/5
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Integer saveUser(UserDTO dto) {

        User user = new User();
        Long id = dto.getId();
        if(id != null){
            user = userMapper.selectById(id);
        }else {
            user.setPassword("111111");
            user.setSalt("zng");
        }
        user.setUserName(dto.getUserName());
        user.setNickName(dto.getNickName());
        user.setUserType(dto.getUserType());
        user.setActivate(dto.getActivate());
        if(id != null){
            return userMapper.updateById(user);
        }else {
            return userMapper.insert(user);
        }
    }

    @Override
    @Transactional
    public Integer updateUser() {
        User user = userMapper.selectById(2L);
        user.setUserType(User.TYPE_NORMAL);
        return userMapper.updateById(user);
    }

    @Override
    public UserDTO getUserInfo(Long id) {
        User user = userMapper.selectById(id);
        return UserDTO.toDTO(user);
    }

    @Override
    public User selectOneByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    @Transactional
    public Integer deletedOne(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public IPage<User> selectAll() {

        Page<User> page = new Page<>();
        page.setCurrent(1L);
        page.setSize(10L);

        return userMapper.selectAll(page);

    }

    @Override
    public TableResponse getUserTable(TableRequest request) {
        Page<User> page = TableUtil.buildPageRequest(request.getPage());
        IPage<User> result = userMapper.selectAll(page);
        return TableUtil.buildPageResponse(result);
    }

    @Override
    public Boolean checkUserName(IdNameDTO request) {
        Long id = request.getId();
        String name = request.getName();

        User user;
        if(id != null){
            user = userMapper.selectById(id);
            if(!StringUtils.isEmpty(name) && name.equals(user.getUserName())){
                return true;
            }
        }
        user = userMapper.selectByName(name);
        if(user != null){
            return false;
        }
        return true;
    }

}
