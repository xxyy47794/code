package com.base.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.base.common.util.AuthUtil;
import com.base.system.user.entity.User;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/5
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Autowired
    private HttpServletRequest request;

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {

        String userName = "未知";
        User user = AuthUtil.getCurrentUser();
        if(user != null){
            userName = user.getNickName();
        }

        LOGGER.info("start insert fill ....");
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("createBy", userName, metaObject);
        this.setFieldValByName("modifyBy", userName, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        String userName = "未知";
        User user = AuthUtil.getCurrentUser();
        if(user != null){
            userName = user.getNickName();
        }
        LOGGER.info("start update fill ....");
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("modifyBy", userName, metaObject);
    }
}
