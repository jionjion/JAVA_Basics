package redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**	连接redis,导入jedis.jar
 * 	E:\Aedis\redis-server.exe
 *	Redis-cli.exe –h 127.0.0.1 –p 6379
 */
public class RedisConnect {

	@Test
	/**使用IP端口进行连接*/
	public void connectByIP() {
		//创建数据库连接,指定IP,端口,超时时间
		Jedis jedis = new Jedis("127.0.0.1", 6379, 2000);
		//保存数据
		jedis.set("name", "张谦");
		//获取数据
		String name = jedis.get("name");
		//打印输出
		System.out.println(name);
		//释放资源
		jedis.close();
	}
	
	@Test
	/**使用连接池进行连接*/
	public void connectByPool() {
		//获得连接池配置对象
		GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
		//设置最大连接数
		genericObjectPoolConfig.setMaxTotal(20);
		//设置最大空闲数
		genericObjectPoolConfig.setMaxIdle(10);
		//创建连接池
		JedisPool jedisPool = new JedisPool(genericObjectPoolConfig, "127.0.01", 6379, 2000);
		//获得核心对象
		Jedis jedis = null;
		try {
			//通过连接池获得
			jedis = jedisPool.getResource();
			//保存数据
			jedis.set("name", "JION.JION");
			//获取数据
			String name = jedis.get("name");
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭连接
			if (jedis != null) {
				jedis.close();
			}
			if (jedisPool != null) {
				jedisPool.destroy();
			}
		}
	}
}
