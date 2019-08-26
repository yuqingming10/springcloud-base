package com.leyou.testconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2019\8\21 0021.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RibbonTest {
    @Autowired
    private RibbonLoadBalancerClient client;

    @Test
    public void test(){
        for (int i = 0; i <50 ; i++) {
            ServiceInstance instance = this.client.choose("test-provider1");
            System.out.println(instance.getHost()+":"+instance.getPort());

        }
    }
}
