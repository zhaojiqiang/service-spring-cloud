package com.zjq.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zjq.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		//http://localhost:7900/simple/
		//VIP virturl ip //虚拟ip
		ServiceInstance choose = loadBalancerClient.choose("service-provider-user");
		System.out.println("==111:" + ":" + choose.getServiceId() + ":" + choose.getHost() + ":" + choose.getPort());
		
		return this.restTemplate.getForObject("http://service-provider-user/simple/" + id, User.class);
	}
	
	@GetMapping("/test")
	public String test() {
		ServiceInstance choose = loadBalancerClient.choose("service-provider-user");
		System.out.println("111:" + ":" + choose.getServiceId() + ":" + choose.getHost() + ":" + choose.getPort());
		
		ServiceInstance choose2 = loadBalancerClient.choose("service-provider-user2");
		System.out.println("222:" + ":" + choose2.getServiceId() +  ":"  + choose2.getHost() + ":" + choose2.getPort() );
		return "1";
	}
}
