package javaEail.until;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectUntil {

	public static Connection getConnect() {
		
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/javabase";
	    String username = "root";
	    String password = "123456";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (Exception e) {
	    	System.err.println("数据库连接时发生异常....");
	    	e.printStackTrace();
	    }
	    return conn;
	}
}
