package com.zjq.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjq.cloud.entity.User;

@FeignClient("service-provider-user")
public interface UserFeignClient {

	
	@RequestMapping(value = "/simple/{id}" ,method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);//使用feign的两个坑  1.GetMapping不支持，2.@PathVariable 的设置value
	
	@RequestMapping(value = "/post-user" ,method = RequestMethod.POST)
	public User PostUser(@RequestBody User user);
	//该请求不会成功，只要参数是复杂对象  即使制定了GET，feign依然会以POST方式发送请求
	@RequestMapping(value = "/get-user" ,method = RequestMethod.GET)
	public User getUser(User user);
	
}
	

