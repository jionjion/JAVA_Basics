package redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ListPosition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**不同种类的数据保存读取*/
public class RedisData {
	
	public GenericObjectPoolConfig genericObjectPoolConfig = null;
	public JedisPool jedisPool = null;
	public Jedis jedis = null;
	
	//构造方法,在类加载时创建
	public RedisData() {
		genericObjectPoolConfig = new GenericObjectPoolConfig();
		//设置最大连接数
		genericObjectPoolConfig.setMaxTotal(20);
		//设置最大空闲数
		genericObjectPoolConfig.setMaxIdle(10);
		//创建连接池
		jedisPool = new JedisPool(genericObjectPoolConfig, "127.0.01", 6379, 2000);
		//创建核心对象
		jedis = jedisPool.getResource();
	}
	
	
	/**String类型的字符获取*/
	@Test
	public void setOrGetString() {
		//保存数据
		jedis.set("name","张谦");
		System.out.println("保存后获取String类型:"+jedis.get("name"));
		//修改数据,值域
		jedis.set("name","JION.JION");
		System.out.println("修改后String类型:"+jedis.get("name"));
		//追加字符串
		jedis.append("name", ".Love");
		System.out.println("追加字符串后为:"+jedis.get("name"));
		//修改数据,键名
		jedis.rename("name", "NAME");
		System.out.println("修改后,键名为:"+jedis.get("NAME"));
		//删除数据
		jedis.del("NAME");
		System.out.println("删除后,NAME值为:"+jedis.get("NAME"));
	}
	
	/**number类型的字符获取,不存在则创建,并保存为0,默认将字符串解析为数字,但要求为整数型*/
	@Test
	public void setOrGetNumber() {
		//保存数据
		jedis.set("count","0");
		//为其自增
		jedis.incr("count");
		System.out.println("自增后数据值为:"+jedis.get("count"));
		//为其自减
		jedis.decr("count");
		System.out.println("自减后数据值为:"+jedis.get("count"));
		//指定数字增加
		jedis.incrBy("count", 10);
		System.out.println("增加后数据值为:"+jedis.get("count"));
		//指定数字减少
		jedis.decrBy("count", 5);
		System.out.println("减少后数据值为:"+jedis.get("count"));
	}
	
	/**Hash类型的使用哈希集合*/
	@Test
	public void setOrGetHash() {
		//保存数据:属性,对象,属性值
		jedis.hset("name", "student", "张谦");
		jedis.hset("age", "student", "23");
		Map<String, String> teacher = new HashMap<String, String>();
		teacher.put("name", "张小谦");
		teacher.put("age", "23");
		//保存数据:对象,属性键值对
		jedis.hmset("teacher", teacher);
		teacher = null;	//置空,删除对象
		//增加或减少数字
		jedis.hincrBy("age", "student", 10);
		//判断属性是否存在
		jedis.hexists("age", "student");
		//读取数据:属性,对象
		String name = jedis.hget("name", "student");
		System.out.println("获取属性值name:"+name);
		//读取数据:对象
		teacher = jedis.hgetAll("teacher");
		System.out.println("获取属性值name:"+teacher.get("name")
						+"\t获取属性值age:"+teacher.get("age"));
		//删除:属性,对象
		jedis.hdel("name", "student");	//删除student对象的name属性
		System.out.println("删除后的属性值name:"+jedis.hget("name", "student"));
		//删除:对象,属性组
		jedis.hdel("teacher", new String[] {"name","age"});
		System.out.println("获取属性值name:"+jedis.hgetAll("teacher").get("name")
		+"\t获取属性值age:"+jedis.hgetAll("teacher").get("age"));
		//删除整个集合
		jedis.del("teacher");
	}
	
	/**List类型的使用双向链表,多用于消息队列*/
	@Test
	public void setOrGetList() {
		//保存对象
		jedis.lpush("左侧链表", "元素一","元素二","元素三");
		jedis.rpush("右侧链表", "元素一","元素二","元素三");
		//查看列表,左侧按照先后顺序,逆向插入,超过越界后会进行循环查询
		System.out.println("查看左侧列表:"+jedis.lrange("左侧链表", 0, 2));
		//查看列表,右侧按照先后顺序,查看全部
		System.out.println("查看右侧列表:"+jedis.lrange("右侧链表", 0, -1));
		//弹出头部元素,弹出后,不再有该元素
		jedis.lpop("左侧链表");
		jedis.rpop("右侧链表");
		//产看链表长度
		System.out.println("左侧链表长度为:"+jedis.llen("左侧链表"));
		System.out.println("右侧链表长度为:"+jedis.llen("右侧链表"));
		//头部压入元素,如果存在该链表,则压入
//		jedis.lpushx("左侧链表", "追加元素一","追加元素二");
//		jedis.rpushx("右侧链表", "追加元素二","追加元素二");
		//修改
		jedis.lset("左侧链表", 0, "开始值");
		jedis.lset("右侧链表", -1,"结束值");
		//在指定元素前进行插入
		jedis.linsert("左侧链表", ListPosition.BEFORE, "元素二", "追加元素");
		//将前者链表弹出到后者
		jedis.rpoplpush("左侧链表", "右侧链表");
	}
	
	/**Set类型的,不允许出现重复,最多4294967295个,多用来跟踪唯一性数据;维护数据对象的聚合关系*/
	@Test
	public void setOrGetSet() {
		//添加元素
		jedis.sadd("集合一", "a","b","c","d","e");
		jedis.sadd("集合二", "c","d","e");
		//删除元素
		jedis.srem("集合一", "d","e");
		//查看数据
		System.out.println("元素一:"+jedis.smembers("集合一"));
		System.out.println("元素二:"+jedis.smembers("集合二"));
		//判断是否在元素
		System.out.println("元素一种是否有a:"+jedis.sismember("集合一", "a"));
		//集合差集运算,集合1-集合2
		//将集合1和集合2的差集赋予集合一
//		jedis.sdiffstore("集合一", "集合一","集合二");
		Set<String> set = jedis.sdiff("集合一","集合二");
		System.out.print("差集运算：");
		for (String string : set) {
			System.out.print(string+"\t");
		}
		//集合交集运算,集合1+集合2
		set = jedis.sinter("集合一","集合二");
		//将集合1和集合2的差集赋予集合一
//		jedis.sinterstore("集合一", "集合一","集合二");
		System.out.println();
		System.out.print("交集运算：");
		for (String string : set) {
			System.out.print(string+"\t");
		}
		//集合并集运算,集合1+集合2
		set = jedis.sunion("集合一","集合二");
		//将集合1和集合2的差集赋予集合一
//		jedis.sunionstore("集合一", "集合一","集合二");
		System.out.println();
		System.out.print("并集运算：");
		for (String string : set) {
			System.out.print(string+"\t");
		}
		//获得成员数量
		System.out.println("集合一个数:"+jedis.scard("集合一"));
		//随机访问
		System.out.println("随机访问集合一"+jedis.srandmember("集合一"));
	}
	
	@Test
	/**有序set的使用,游戏排序,索引构建*/
	public void setOrGetSortedSet() {
		//增加
		Map<String, Double> set = new HashMap<String,Double>();
		set.put("张三", 95D);set.put("李四", 98D);set.put("王五", 97D);set.put("赵六", 94D);
		jedis.zadd("排序", set);
		//查询
		System.out.println("张三分数:"+jedis.zscore("排序", "张三"));
		//查询当前集合数量
		System.out.println("当前集合数量:"+jedis.zcard("排序"));
		//删除
//		jedis.zrem("排序", "张三","李四");
		//范围查找
		jedis.zrange("排序", 0, -1);		//插叙到最后一个的集合
		//从小到大排序
		jedis.zrevrange("排序", 0, -1);	//倒叙排列
		//按照范围进行删除
		jedis.zremrangeByScore("排序", 0, 4);	//删除0~4范围的
		//按照分数显示前两个
		jedis.zrangeByScore("排序", 0, 100);	
		//指定元素修改
		jedis.zincrby("排序", 3d, "李四");
		//查询指定段的数量
		jedis.zcount("排序", 95, 100);
	}
	
	@Test
	/**通用操作*/
	public void commonOperate() {
		//删除
		jedis.del("对象一");
		//判断否存在
		jedis.exists("对象二");
		//重命名
		jedis.rename("对象一", "新对象一");
		//设置过期时间,单位s
		jedis.expire("对象二", 100);
		//所剩时间
		jedis.ttl("对象二");
		//获取key的类型
		jedis.type("排序");		//返回排序哈希类型
		//清空数据库
		jedis.flushAll();
		//清空当前子数据库
		jedis.flushDB();
	}
}
