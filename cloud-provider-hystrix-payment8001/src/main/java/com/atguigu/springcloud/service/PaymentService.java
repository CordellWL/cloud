package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Cordell
 */
@Service
public class PaymentService {

	/**
	 *正常访问，肯定行
	 * @param id
	 * @return
	 */
	public String paymentInfo_OK(Integer id){
		return "线程池"+Thread.currentThread().getName()+"paymentInfo_OK"+id+"\t"+"6666666666";
	}

	@HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
			})
	public String paymentInfo_timeOut(Integer id){
		int timeNumber=3000;
		//int age=10/0;
		try {
			TimeUnit.MILLISECONDS.sleep(timeNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "线程池"+Thread.currentThread().getName()+"paymentInfo_timeOut"+id+"\t"+"5555555555"+"耗时:"+timeNumber+"秒";
	}

	public String paymentInfo_timeOutHandler(Integer id){
		return "线程池"+Thread.currentThread().getName()+"8001系统运行错误，请稍后重试"+id+"\t"+"/(ㄒoㄒ)/~~";

	}

	@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到X后跳闸
	})
	public String paymentCircuitBreaker(@PathVariable("id") Integer id){
		if (id<0){
			throw new RuntimeException("*****id不能为负数");
		}
		String serialNumber= IdUtil.simpleUUID();

		return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;

	}

	public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
		return "id不能为负数,请稍后再试 id:"+id;
	}

}
