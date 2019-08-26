package com.leyou.testconsumer.client;

import com.leyou.testconsumer.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2019\8\22 0022.
 */
@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(@PathVariable("id") Long id) {
        User user = new User();
        user.setName("熔断类");
        return user;
    }
}
