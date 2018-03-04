package com.wipro.customertool.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CORSInterceptor extends HandlerInterceptorAdapter {
	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		return true;
//	}
	
//	@Override
//	public void postHandle(
//			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
//			throws Exception {
//		response.addHeader("Access-Control-Allow-Origin", "*");
//	}
}
