package jdbc.MysqlJDBC.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import jdbc.MysqlJDBC.model.Goddess;
import jdbc.MysqlJDBC.until.DBUntil;


/**调用存储过程*/
public class ProcedureDao {

	/**
	 * 	调用无参的存储过程
	 * 	create  procedure `sp_select_nofilter`()
	 *	begin
	 *		select * from goddess;
	 *	end
	 * */
	public List<Goddess> procedure_select_nofilter() {
		try {
			//1.获得数据库连接
			Connection connection = DBUntil.getMySQLConnection();
			//2.获得存储过程调用对象
			String sql = " call sp_select_nofilter() ";
			CallableStatement callableStatement = connection.prepareCall(sql);
			//3.执行存储过程,返回是否执行成功的布尔值
			callableStatement.execute();
			//4.处理返回的结果.结果集|出参
			ResultSet resultSet = callableStatement.getResultSet();
			List<Goddess> list = new ArrayList<Goddess>();
			Goddess goddess = null;
			while(resultSet.next()){
				goddess = new Goddess();
				goddess.setId(resultSet.getInt("id"));			//传入序号,告知获得第几个参数
				goddess.setUserName(resultSet.getString("user_name"));
				goddess.setSex(resultSet.getString("sex"));
				goddess.setAge(resultSet.getInt("age"));
				goddess.setBirthday(resultSet.getDate("birthday"));
				goddess.setEmail(resultSet.getString("email"));	
				goddess.setMobile(resultSet.getString("mobile"));
				goddess.setCreateUser(resultSet.getString("create_user"));
				goddess.setCreateDate(resultSet.getDate("create_date"));
				goddess.setUpdateUser(resultSet.getString("update_user"));
				goddess.setUpdateDate(resultSet.getDate("update_date"));
				goddess.setIsDel(resultSet.getInt("isdel"));
				list.add(goddess);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("调用存储过程中出现意外....");
		}
		return null;
	}

	
	/**
	 * 	调用有参的储存过程
	 *	create definer=`root`@`localhost` procedure `sp_select_filter`(in p_name varchar(20))
	 *	begin
	 *		if p_name is null or p_name = '' then
	 *			select * from goddess;
	 *		else
	 *			select * from goddess where user_name like concat('%',p_name,'%');
	 *		end if;
	 *	end
	 * */
	public List<Goddess> procedure_select_filter(String userName) {
		try {
			//1.获得数据库连接
			Connection connection = DBUntil.getMySQLConnection();
			//2.获得存储过程调用对象
			String sql = " call sp_select_filter(?) ";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setString(1, userName);
			//3.执行存储过程,返回是否执行成功的布尔值
			callableStatement.execute();
			//4.处理返回的结果.结果集|出参
			ResultSet resultSet = callableStatement.getResultSet();
			List<Goddess> list = new ArrayList<Goddess>();
			Goddess goddess = null;
			while(resultSet.next()){
				goddess = new Goddess();
				goddess.setId(resultSet.getInt("id"));			//传入序号,告知获得第几个参数
				goddess.setUserName(resultSet.getString("user_name"));
				goddess.setSex(resultSet.getString("sex"));
				goddess.setAge(resultSet.getInt("age"));
				goddess.setBirthday(resultSet.getDate("birthday"));
				goddess.setEmail(resultSet.getString("email"));	
				goddess.setMobile(resultSet.getString("mobile"));
				goddess.setCreateUser(resultSet.getString("create_user"));
				goddess.setCreateDate(resultSet.getDate("create_date"));
				goddess.setUpdateUser(resultSet.getString("update_user"));
				goddess.setUpdateDate(resultSet.getDate("update_date"));
				goddess.setIsDel(resultSet.getInt("isdel"));
				list.add(goddess);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("调用存储过程中出现意外....");
		}
		return null;
	}
	
	/**
	 * 	调用出参的存储过程
	 * 	
	 * 
	 * 
	 * */
	public int procedure_select_count() {
		try {
			//1.获得数据库连接
			Connection connection = DBUntil.getMySQLConnection();
			//2.获得存储过程调用对象
			String sql = " call sp_select_count(?) ";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.registerOutParameter(1, Types.INTEGER);
			//3.执行存储过程,返回是否执行成功的布尔值
			callableStatement.execute();
			//4.处理返回的结果.出参
			int count = callableStatement.getInt(1);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("调用存储过程中出现意外....");
		}
		return 0;
	}
}
