package jdbc.MysqlJDBC.until;

import java.sql.Connection;
import java.sql.DriverManager;


/**DB连接的工作获取类*/
public class DBUntil {
	
	private static final String driver = "com.mysql.jdbc.Driver"; 
	private static final String url = "jdbc:mysql://127.0.0.1:3306/javabase?useUnicode=true&amp;characterEncoding=UTF-8";
	private static final String user = "root";
	private static final String password = "123456";
	private static Connection connection = null;
	
	/**使用静态代码块在类初始化的时候加载到内存中,避免重复加载,减少内存开支*/
	static {
		
		try {
			//1.加载驱动程序
			Class.forName(driver);
			//2.获得数据库的连接
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("数据库连接获取发生异常...");
		}
	}
	
	/**获得数据库连接*/
	public static Connection getMySQLConnection(){
		return connection;
	}
}
