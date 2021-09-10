package commons.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.apache.commons.dbcp2.BasicDataSource;


/**
 * 使用DBCP连接池连接MySQL数据库
 */
public class MysqlDbcpExample {

    public static void main(String[] args) throws Exception {

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost/javabase");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");

        //保持活动的最小连接数
        basicDataSource.setMinIdle(5);
        //最大空闲数
        basicDataSource.setMaxIdle(10);
        //查询缓存对象
        basicDataSource.setMaxOpenPreparedStatements(100);

        //获得链接
        Connection connection = basicDataSource.getConnection();
        //预编译SQL
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
        //select * from user where id = 1
        preparedStatement.setInt(1, 1);
        //查询,返回结果
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("姓名:" + resultSet.getString("username")
                    + "生日:" + new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate("brithday")));
        }
        //关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
        basicDataSource.close();
    }
}
