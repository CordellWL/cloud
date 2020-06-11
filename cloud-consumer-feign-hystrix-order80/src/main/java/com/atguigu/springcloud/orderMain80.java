package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Cordell
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class orderMain80 {
	public static void main(String[] args) {
		SpringApplication.run(orderMain80.class,args);
	}
}
