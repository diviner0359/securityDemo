package com.mmall.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	@RequestMapping("/")
	public String home(){
		return "hello spring boot";
	}

	@RequestMapping("/hello")
	public String hello(){
		return "hello world";
	}

	@RequestMapping("/roleAuth")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String role(){
		return "admin auth";
	}

}
