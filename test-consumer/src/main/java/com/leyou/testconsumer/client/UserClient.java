package com.leyou.testconsumer.client;

import com.leyou.testconsumer.configuration.FeignLogConfiguration;
import com.leyou.testconsumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2019\8\22 0022.
 */
@FeignClient(value = "test-provider1",fallback = UserClientFallback.class,configuration = FeignLogConfiguration.class) //生产者服务名
public interface UserClient {

    @GetMapping("user/{id}")  //如果生产者controller类上有@RequestMapping("user")，在方法上拼接此user
    public User queryById(@PathVariable("id") Long id);
}
