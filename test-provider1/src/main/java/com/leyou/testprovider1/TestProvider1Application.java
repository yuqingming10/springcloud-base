package com.leyou.testprovider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TestProvider1Application {

	public static void main(String[] args) {
		SpringApplication.run(TestProvider1Application.class, args);
	}

}
