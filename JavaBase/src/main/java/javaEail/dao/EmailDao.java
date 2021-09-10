package javaEail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javaEail.bean.User;
import javaEail.until.ConnectUntil;

/**将业务表同步到数据库中*/
public class EmailDao {

	/**保存用户数据的*/
	public void regist(User user){
		
		try {
			String sql = " insert into userEmail value (?,?,?,?,?,?,?) ";
			Connection connection = ConnectUntil.getConnect();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,user.getUid());
			preparedStatement.setString(2,user.getUsername());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getNickname());
			preparedStatement.setString(5,user.getEmail());
			preparedStatement.setInt(6,user.getState());
			preparedStatement.setString(7,user.getCode());
			preparedStatement.execute();
		} catch (SQLException e) {
			System.err.println("持久化过程出现意外...");
			e.printStackTrace();
		}
	}

}
