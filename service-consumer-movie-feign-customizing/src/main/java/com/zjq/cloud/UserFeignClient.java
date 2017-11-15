package com.zjq.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.zjq.cloud.entity.User;
import com.zjq.config.ConfigurationX;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "service-provider-user" ,configuration = ConfigurationX.class)
public interface UserFeignClient {

	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);//使用feign的两个坑  1.GetMapping不支持，2.@PathVariable 的设置value
	
	
}
	

