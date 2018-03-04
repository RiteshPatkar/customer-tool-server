package com.wipro.customertool.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.wipro.customertool.interceptor.CORSInterceptor;

@Configuration
@EnableWebMvc
public class ServiceConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	CORSInterceptor corsInterceptor() {
		return new CORSInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(corsInterceptor());
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedMethods("PUT", "DELETE", "GET", "POST")
			.allowCredentials(false).maxAge(3600);
	}

}
