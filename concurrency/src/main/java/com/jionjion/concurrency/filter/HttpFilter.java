package com.jionjion.concurrency.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 	过滤器,通过每次请求获得对应的线程信息,避免重复性调用请求获取
 * 		这里使用过滤器,调用线程信息类,将不同线程传递的参数,保存在各自线程的私有变量中
 */
@Slf4j
public class HttpFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest  request = (HttpServletRequest) servletRequest;
		HttpServletResponse response= (HttpServletResponse) servletResponse;
		
		log.info("过滤器请求 {} ",request.getServletPath());
		String username = StringUtils.isEmpty(request.getParameter("username")) ? 
							"Jion" : request.getParameter("username");
		//调用线程保存
		ThreadInfo.setInfo(username);
		//过滤结束
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

	
}
