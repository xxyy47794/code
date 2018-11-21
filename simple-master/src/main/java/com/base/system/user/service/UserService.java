package com.base.system.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.common.dto.IdNameDTO;
import com.base.common.table.entity.TableRequest;
import com.base.common.table.entity.TableResponse;
import com.base.system.user.dto.UserDTO;
import com.base.system.user.entity.User;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/5
 */
public interface UserService {

    Integer saveUser(UserDTO userDTO);

    Integer updateUser();

    UserDTO getUserInfo(Long id);

    User selectOneByName(String name);

    Integer deletedOne(Long id);

    IPage<User> selectAll();

    TableResponse getUserTable(TableRequest request);

    Boolean checkUserName(IdNameDTO request);
}
