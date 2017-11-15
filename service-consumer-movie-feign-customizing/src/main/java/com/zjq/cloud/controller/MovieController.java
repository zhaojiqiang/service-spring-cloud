package com.zjq.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zjq.cloud.FeignClient2;
import com.zjq.cloud.UserFeignClient;
import com.zjq.cloud.entity.User;

@RestController
public class MovieController {

	
	@Autowired
	private UserFeignClient userFeignClient;
	

	@Autowired
	private FeignClient2 feignClient2;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		System.out.println("wocao");
		return userFeignClient.findById(id);
	}
	
	
	@GetMapping("/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable String  serviceName) {
		System.out.println("wocao");
		return feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
	}
	

}
