package com.base.system.user.dto;

import com.base.system.user.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class UserDTO {

    private Long id;

    private String nickName;

    private String userName;

    private String userType;

    private Boolean activate;

    private Date lastLogin;

    public static UserDTO toDTO(User user){

        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user,dto);

        return dto;
    }

}
