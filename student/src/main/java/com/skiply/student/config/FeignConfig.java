package com.skiply.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;
import feign.Retryer;

@Configuration
public class FeignConfig {
	
	@Bean
	public Request.Options timeoutConfigurations(){
		return new Request.Options(5000,10000);
	}
	
	@Bean
	public Retryer retryer() {
		return new Retryer.Default(1000, 3000, 2);
	}

}
