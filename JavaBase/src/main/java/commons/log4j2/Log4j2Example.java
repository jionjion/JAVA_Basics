package commons.log4j2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * @author JionJion
 *	JDK的logging方式,最多支持到info级别
 *		四月 09, 2018 7:48:29 下午 commons.logging.LoggingExample main
 *		信息: info级别....
 *		四月 09, 2018 7:48:29 下午 commons.logging.LoggingExample main
 *		严重: error级别....	
 *
 *	Log4j2是日志接口slf4j的实现类,类似的实现还有logback和log4j
 *	核心jar为
 *		log4j-api	
 *		log4j-core 
 *	在引入日志框架时,如果不指定配置文件,默认提供的日志级别为Error级别并输出到控制台中
 *		默认级别	all < trace < debug < info < warn < error < fatal < off
 *	配置文件,一般放置在src/main/resources根目录,以log4j2.xml、log4j.json、log4j.jsn等名称,如果没有找到,则使用默认配置
 *
 */
public class Log4j2Example {
	
	/*
	 *	Web工程中配置方式
	 *	<context-param>  
	 *	    <param-name>log4jConfiguration</param-name>  
	 *	    <param-value>/WEB-INF/conf/log4j2.xml</param-value>  
	 *	</context-param>  
	 * */
	static {
		try {
			//使用java方式,重新配置日志配置文件和位置
			String xmlPath = System.getProperty("user.dir") + "/src/commons/log4j2/log4j2-01.xml";
			File file = new File(xmlPath);  
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));  
			ConfigurationSource source = new ConfigurationSource(in);  
			Configurator.initialize(null, source);  		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
		
		logger.trace("trace级别...");
		logger.debug("debug级别...");
		logger.info("info级别...");
		logger.warn("warn级别...");
		logger.error("error级别...");
		logger.fatal("fatal级别...");
	}
}
/*
	配置文件格式
		Configuration 							根节点	status属性控制log4j2日志框架本身的日志级别  
														monitorInterval属性每隔多少秒重新读取配置文件
			properties							定义常量
			Appenders 							输出源,指定输出的位置,有很多,且支持扩展
				Console 						控制台输出
					PatternLayout				控制台或文件输出源中必须含有,指定输出的文件格式
				File							文件输出
				RollingRandomAccessFile			文件输出,支持拆分文件
				NoSql							输出到非关系型数据库中
				Flume							输出到Apache Flume
				Async							异步输出
		Loggers 								日志器	根日志器root和自定义日志器 
			Logger								自定义日志器	name属性为日志器命名,多以包名命名,配置不同的输出等级
			Root 
				AppenderRef		
 */ 