package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cordell
 * Json封装体CommonResult
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
	private Integer code;
	private String  message;
	private  T      date;

	public CommonResult(Integer code,String message){
		this(code,message,null);
	}
}
