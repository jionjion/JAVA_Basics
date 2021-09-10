package com.model.proxy.dynamical.proxy;

import java.lang.reflect.Method;

/**自定义业务抽取器*/
public interface InvocationHandler {

	/**自定义的实现类方法*/
	public void	invoke(Object object,Method method);
}
