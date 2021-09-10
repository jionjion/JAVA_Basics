package jdbc.MysqlJDBC.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.MysqlJDBC.model.Goddess;
import jdbc.MysqlJDBC.until.C3P0Pool;
import jdbc.MysqlJDBC.until.DBUntil;

/**女神表的*/
public class GoddessDao {

	/**增*/
	public void addGoddess(Goddess goddess) {
		try {
			Connection connection = DBUntil.getMySQLConnection();
			String sql = " insert into goddess ("
					+ "		user_name,sex,age,birthday,email,mobile,"
					+ "		create_user,create_date,update_user,update_date,isDel)"
					+ " 	value(?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, goddess.getUserName());
			preparedStatement.setString(2, goddess.getSex());
			preparedStatement.setInt(3, goddess.getAge());
			preparedStatement.setDate(4, new Date(goddess.getBirthday().getTime()));
			preparedStatement.setString(5, goddess.getEmail());
			preparedStatement.setString(6, goddess.getMobile());
			preparedStatement.setString(7, goddess.getCreateUser());
			preparedStatement.setString(8, goddess.getUpdateUser());
			preparedStatement.setInt(9, goddess.getIsDel());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("修改时发生意外.........");
		}
	}
	
	/**删*/
	public void deleteGoddess(Goddess goddess) {
		try{
			Connection connection = DBUntil.getMySQLConnection();
			String sql = " delete from goddess "
					+ " 	where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, goddess.getId());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("删除时发生意外.........");
		}
	}
	
	/**改*/
	public void updateGoddess(Goddess goddess) {
		try{
			Connection connection = DBUntil.getMySQLConnection();
			String sql = " update goddess set "
					+ "		user_name = ?,sex = ?,age = ?,birthday = ?,email = ?,mobile = ?,"
					+ "		update_user = ?,update_date = current_date(),isDel =?"
					+ " 	where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, goddess.getUserName());
			preparedStatement.setString(2, goddess.getSex());
			preparedStatement.setInt(3, goddess.getAge());
			preparedStatement.setDate(4, new Date(goddess.getBirthday().getTime()));
			preparedStatement.setString(5, goddess.getEmail());
			preparedStatement.setString(6, goddess.getMobile());
			preparedStatement.setString(7, goddess.getUpdateUser());
			preparedStatement.setInt(8, goddess.getIsDel());
			preparedStatement.setInt(9, goddess.getId());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("修改时发生意外.........");
		}
	}
	
	/**查询列表*/
	public List<Goddess> queryGoddess(){
		try {
			Connection connection = DBUntil.getMySQLConnection();
//			Connection connection = C3P0Pool.getC3P0Connection();
			Statement statement = connection.createStatement();
			String sql = "select user_name,age from goddess";
			ResultSet resultSet = statement.executeQuery(sql);
			List<Goddess> list = new ArrayList<Goddess>();
			Goddess goddess = null;
			while(resultSet.next()){
				goddess = new Goddess();
				goddess.setUserName(resultSet.getString("user_name"));
				goddess.setSex(resultSet.getString("age"));
				list.add(goddess);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("查询时发生意外....");
		}
		return null;
	}
	
	/**查询单个*/
	public Goddess getGoddess(Goddess goddess) {
		try{
//			Connection connection = DBUntil.getMySQLConnection();
			Connection connection = C3P0Pool.getC3P0Connection();
			String sql = " select id, user_name,sex,age,birthday,email,mobile,"
					+ "		create_user,create_date,update_user,update_date,isDel "
					+ " 	from goddess where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, goddess.getId());
			ResultSet resultSet = preparedStatement.executeQuery();	//针对查询时使用
			Goddess resultGoddess = null;
			while (resultSet.next()) {
				resultGoddess = new Goddess();
				resultGoddess.setId(resultSet.getInt(1));			//传入序号,告知获得第几个参数
				resultGoddess.setUserName(resultSet.getString(2));
				resultGoddess.setSex(resultSet.getString(3));
				resultGoddess.setAge(resultSet.getInt(4));
				resultGoddess.setBirthday(resultSet.getDate(5));
				resultGoddess.setEmail(resultSet.getString(6));	
				resultGoddess.setMobile(resultSet.getString(7));
				resultGoddess.setCreateUser(resultSet.getString(8));
				resultGoddess.setCreateDate(resultSet.getDate(9));
				resultGoddess.setUpdateUser(resultSet.getString(10));
				resultGoddess.setUpdateDate(resultSet.getDate(11));
			}
			return resultGoddess;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("查询时发生意外.........");
		}
		return null;
	}
	
	/**条件查询*/
	public List<Goddess> queryGoddessBySome(List<Map<String, Object>> param){
		try {
			Connection connection = DBUntil.getMySQLConnection();
			Statement statement = connection.createStatement();
			StringBuffer sql = new StringBuffer(" select * from goddess where 1=1");
			if (param != null && param.size()>0) {
				for (int i = 0; i < param.size(); i++) {
					Map<String, Object> map = param.get(i);
					//	条件		关系		条件值
					sql.append(" and "+map.get("key")+" "+map.get("nexus")+" "+map.get("value"));
				}
			}
			ResultSet resultSet = statement.executeQuery(sql.toString());
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
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("条件查询时发生意外....");
		}
		return null;
	}

}
