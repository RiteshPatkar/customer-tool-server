package com.wipro.customertool.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.wipro.customertool.main.interceptor.CORSInterceptor;

@Configuration
public class ServiceConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	CORSInterceptor corsInterceptor() {
		return new CORSInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(corsInterceptor());
	}

}
