package com.zjq.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjq.config.ConfigurationY;
				//没有url的时候,用的name 是eureka的注册服务名，有url 那么、 就无所谓了‘
@FeignClient(name = "xxxx" , url = "http://localhost:8761",configuration = ConfigurationY.class)
public interface FeignClient2 {
	
	@RequestMapping(value = "/eureka/apps/{serviceName}" , method = RequestMethod.GET)
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);

}
