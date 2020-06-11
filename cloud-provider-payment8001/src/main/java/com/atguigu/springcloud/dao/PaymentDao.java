package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.atguigu.springcloud.entities.Payment;

/**
 * @author Cordell
 */
@Mapper
public interface PaymentDao {
	/**
	 * 添加信息
	 **/
	public int create(Payment payment);


	/**
	 * 添加信息
	 **/
	public Payment getPaymentByID(@Param("id") Long id);

}
