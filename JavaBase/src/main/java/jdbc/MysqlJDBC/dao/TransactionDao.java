package jdbc.MysqlJDBC.dao;


import java.sql.Connection;

import jdbc.MysqlJDBC.until.DBUntil;

/***
 * 	原子性:事务是一个完整的操作
 *	一致性:当事务完成时,数据必须处于一致状态
 *	隔离性:对数据进行修改的所有并发事务是彼此隔离的
 *	永久性:当事务完成后,它对数据库的修改是永久的
 *
 *	commit:提交
 *	rollback:回滚
 *	
 *	事务默认是自动提交的
 *
 *	setAutoCommit(false):禁止自动提交
 */
public class TransactionDao {

	/**使用事务,保证操作一致性*/
	public void transaction() throws Exception {
		
		Connection connection = DBUntil.getMySQLConnection();
		//1.禁止自动提交
		connection.setAutoCommit(false);
		try {
			/*业务部分,成立则提交,失败则回滚*/
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("事务操作出现异常.......");
			connection.rollback(); 	//回滚事务
		}
	}
}
