package com.atguigu.springcloud.serivice;

import org.apache.ibatis.annotations.Param;
import com.atguigu.springcloud.entities.Payment;

/**
 * @author Cordell
 */
public interface PaymentService {
	/**
	 * 添加信息
	 **/
	public int create(Payment payment);


	/**
	 * 添加信息
	 **/
	public Payment getPaymentByID(@Param("id") Long id);
}
