package com.leyou.testconsumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableFeignClients
public class TestConsumerApplication {
	/*@Bean  //如果用feign组件就不用再注册RestTemplate了
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();//这里配置随机策略，和配置文件对应
	}
	public static void main(String[] args) {
		SpringApplication.run(TestConsumerApplication.class, args);
	}

}
