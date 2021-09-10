package com.model.proxy.dynamical.proxy;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;


/**自定义实现动态代理类*/
public class Proxy {

	
	/**自定义返回一个动态代理 */
	public static Object newProxyInstance(Class<?> inface,InvocationHandler handler) throws Exception{
		//1.声明一段源码
		String rt = "\t\n";
		String methodName = "";
		String code = "";
		
		for(Method method : inface.getMethods() ){
			methodName += 
		"	@Override														"+rt+
		"	public void "+ method.getName() +"() {											"+rt+
		"		try{"								+rt+
		"		Method method = "+inface.getName()+".class.getMethod(\""+method.getName() +"\");	"+rt+
		"		handler.invoke(this,method);													"+rt+
		"	}catch(Exception e){ e.printStackTrace();	}	"+rt+
		"	}																";
		}
		
		code += 
		"	package com.model.proxy.dynamical.proxy;	"+rt+
		"	import com.model.proxy.dynamical.proxy.InvocationHandler;	"+rt+
		"	import java.lang.reflect.Method;	"+rt+
		"	public class $Proxy0 implements " +inface.getName()+ "{	"+rt+
		"	private InvocationHandler handler;								"+rt+
		"	public $Proxy0 ( InvocationHandler handler) {									"+rt+
		"		this.handler = handler;												"+rt+
		"	}																"+rt+
				methodName+
		"}																	";
		//2.生成文件,编译源码
		//获得当前的路径
		String fileName = System.getProperty("user.dir");
		System.out.println("当前文件的路径:"+fileName);
		//创建编译环境
		fileName = fileName + "/bin/com/model/proxy/dynamical/proxy/$Proxy0.java";
		File file = new File(fileName);
		FileUtils.write(file, code);
		//拿到编译器
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		//得到文件管理者
		StandardJavaFileManager standardJavaFileManager = 
					javaCompiler.getStandardFileManager(null, null, null);
		//得到文件
		Iterable<? extends JavaFileObject> units = standardJavaFileManager.getJavaFileObjects(fileName);
		//编译任务
		CompilationTask compilationTask = javaCompiler.getTask(null, standardJavaFileManager, null, null, null, units);
		//进行编译
		compilationTask.call();
		//关闭
		standardJavaFileManager.close();
		
		//加载到内存中
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> c = classLoader.loadClass("com.model.proxy.dynamical.proxy.$Proxy0");
		System.out.println("加载自定义的类:"+c.getName());
		
		//根据构造器创建对象
		Constructor<?> constructor = c.getConstructor(InvocationHandler.class);
		//返回创建对象
		return constructor.newInstance(handler);
	}
}
