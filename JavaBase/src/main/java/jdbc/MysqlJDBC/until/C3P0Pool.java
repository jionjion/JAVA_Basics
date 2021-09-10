package jdbc.MysqlJDBC.until;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**	使用C3P0连接池,完成数据库的连接.
 * */
/**	使用C3P0连接池,完成数据库的连接.*/
public class C3P0Pool {

	
	private static ComboPooledDataSource dataSource = null;
	private static Properties properties = null;
	
	static {
		try {
			dataSource = new ComboPooledDataSource();	//初始化数据源
			properties = new Properties();				//初始化属性文件
			InputStream inputStream = new FileInputStream("F:\\JAVA_WorkSpace\\JavaBase\\src\\jdbc\\property\\c3p0.properties");
			properties.load(inputStream);				//以IO形式将属性文件加载
			dataSource.setDriverClass(properties.getProperty("c3p0.driverClass"));
			dataSource.setJdbcUrl(properties.getProperty("c3p0.jdbcUrl"));
			dataSource.setUser(properties.getProperty("c3p0.user"));
			dataSource.setPassword(properties.getProperty("c3p0.password"));
			inputStream.close();						//关闭输入流
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("加载属性文件出现异常........");
		}
	}
	
	public static Connection getC3P0Connection() {
		try {
			
			Connection connection = dataSource.getConnection();
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("C3P0连接池出现异常....");
		}
		return null;
	}
	
	public static void main(String[] args) {

		System.out.println(properties.getProperty("c3p0.driverClass"));
		System.out.println(properties.getProperty("c3p0.jdbcUrl"));
		System.out.println(properties.getProperty("c3p0.user"));
		System.out.println(properties.getProperty("c3p0.password"));
		System.out.println(getC3P0Connection());
	}
}
