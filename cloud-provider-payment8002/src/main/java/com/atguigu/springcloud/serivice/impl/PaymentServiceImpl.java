package com.atguigu.springcloud.serivice.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.serivice.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Cordell
 */
@Service
public class PaymentServiceImpl implements PaymentService {
	@Resource
	private PaymentDao paymentDao;

	/**
	 * 添加信息
	 *
	 * @param payment
	 */
	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	/**
	 * 添加信息
	 *
	 * @param id
	 */
	@Override
	public Payment getPaymentByID(Long id) {
		return paymentDao.getPaymentByID(id);
	}
}
