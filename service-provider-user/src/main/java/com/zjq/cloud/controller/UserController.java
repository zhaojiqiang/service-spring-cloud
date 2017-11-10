package com.zjq.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zjq.cloud.dao.UserRepository;
import com.zjq.cloud.entity.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("SERVICE-PROVIDER-USER", false);
	    return instance.getHomePageUrl();
	}
	
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
	    ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
	    return localServiceInstance;
	}

	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}

}
