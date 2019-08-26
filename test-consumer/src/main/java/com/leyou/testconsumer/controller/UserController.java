package com.leyou.testconsumer.controller;

import com.leyou.testconsumer.client.UserClient;
import com.leyou.testconsumer.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019\8\20 0020.
 */
@Controller
@RequestMapping("consumer/user")
//@DefaultProperties(defaultFallback = "feedback")  //如果用feign组件就不用再写此句
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

   /* @Autowired  //如果用feign组件就不用再注册RestTemplate了
    private RestTemplate restTemplate;*/

   @Autowired(required = false)
   private UserClient userClient;

    @GetMapping
    @ResponseBody
//    @HystrixCommand  //局部熔断方法(fallbackMethod = "queryUserByIdFallBack")  //如果用feign组件就不用再写此句
    public User queryUserById(@RequestParam("id") Long id){
        ////如果用feign组件就不用再写下面注释掉的代码
/*//        User user = this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
        if(id == 1){
            throw new RuntimeException("太忙了");
        }
        User user = this.restTemplate.getForObject("http://test-provider1/user/" + id, User.class);
        return user;*/
        User user = userClient.queryById(id);
        logger.info("test-consumer/controller你好");
        System.out.println(user.toString());

        return user;
    }
    public User queryUserByIdFallBack(Long id){
        System.out.println("局部熔断方法");
        return null;
    }
    public User feedback(){
        System.out.println("全局熔断方法");
        return null;
    }
}
