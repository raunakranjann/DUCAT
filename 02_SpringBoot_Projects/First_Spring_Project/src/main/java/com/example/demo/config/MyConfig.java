package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.UserService;
@Configuration
public class MyConfig {
	
	@Bean(name = {"my"})
	public UserService getUser() {
	return new UserService();
	}
}
