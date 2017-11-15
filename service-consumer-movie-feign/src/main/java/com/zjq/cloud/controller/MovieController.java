package com.zjq.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zjq.cloud.UserFeignClient;
import com.zjq.cloud.entity.User;

@RestController
public class MovieController {

	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		System.out.println("wocao");
		return userFeignClient.findById(id);
	}
	
	@GetMapping("/test-post")
	public User testPostUser(User user) {
		System.out.println("wocao");
		return this.userFeignClient.PostUser(user);
	}
	
	//该请求不会成功，只要参数是复杂对象  即使制定了GET，feign依然会以POST方式发送请求
	@GetMapping("/test-get")
	public User testGetUser(User user) {
		System.out.println("wocao");
		return this.userFeignClient.getUser(user);
	}
}
