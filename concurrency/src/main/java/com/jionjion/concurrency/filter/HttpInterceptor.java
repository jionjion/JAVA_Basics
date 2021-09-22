package com.jionjion.concurrency.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 	对调用方法进行代理拦截
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter{

	/**
	 * 	在方法调用前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("方法执行前执行...");
		return true;
	}

	/**
	 * 	在方法调用后执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//方法调用结束后,移除线程中的信息
		ThreadInfo.remove();
		log.info("方法执行后执行...");
		return ;
	}

	
}
