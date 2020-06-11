package com.atguigu.springcloud.serivice;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

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
