package com.leyou.testprovider1.service;

import com.leyou.testprovider1.controller.UserController;
import com.leyou.testprovider1.mapper.UserMapper;
import com.leyou.testprovider1.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019\8\19 0019.
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired(required = false)
    private UserMapper userMapper;

    public User queryById(Long id) {
        User user1 = new User();
        user1.setId(id.intValue());
        User user = this.userMapper.selectOne(user1);
        logger.info("test-provider1/service你好" );
        System.out.println(user);
        return user;
    }
}
