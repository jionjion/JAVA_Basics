---
title: JAVA中使用自定义注解
tags : JDK8,Eclipse
---

[TOC]

---

## 简介
模仿 Hibernate实现基于注解的SQL语句生成,通过在Bean中添加自定义注解`@Table`和`@Column`,将Bean中的属性映射为表中字段,通过set()方法,为Bean中装入查询条件,实现自动生成SQL语句.

## 类文件

* `Column`  自定义注解类,标注为数据库字段
* `Table` 自定义注解类,标注为数据库表
* `User` 一个javaBean,将基于此创建数据库映射关系
* `QueryTest` 测试类

## 编码详设

### 自定义`@Table`,`@Column`注解

 - `@interface`声明注解名称
 - `@Target`声明注解作用范围为作用类上/字段上
 - `@Retention`申明为运行时注解

Table.java文件:
``` java
@Target({ElementType.TYPE})				//类上的注解
@Retention(RetentionPolicy.RUNTIME)		//运行时注解
public @interface Table {
	String value();
}
```

Column.java文件:
``` java
@Target({ElementType.FIELD})				//字段上的注解
@Retention(RetentionPolicy.RUNTIME)		//运行时注解
public @interface Column {
	String value();
}
```

### 在JavaBean中使用自定义注解

 1. Bean的类名中使用`@Table`注解,指明映射表名
 2. 在私有属性中使用`@Column`注解,指明映射字段名
 3. 分别生成get/set方法,构成一个JavaBean

``` java
@Table("user")						//自定义注解,表名
public class User {

	@Column("id")					//自定义注解,字段名
	private int id;					//私有属性中保存的值,为查询条件的值

	@Column("user_name")
	private String username;

	@Column("nick_name")
	private String nickName;

	@Column("age")
	private int age;

	@Column("email")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}  
}
```
### 解析方法

 1. 将类的实例传入,通过反射获得类上的`@Table`注解,进而获得映射的表名.
 2. 获得并遍历类的所有属性,凡是在属性中存在自定义注解`@Column`的,获取查询条件.
 3. 针对参数为String,int,数组的形式,进行分割,追加拼接为SQL语句
``` java
	private static String query(User user) throws Exception{
		StringBuffer sql = new StringBuffer();
		//获取被注解表示的类
		Class<?> clazz = user.getClass();
		//获取类上的表示表名的注解
		//首先判断是否存在该注解
		boolean tableExist = clazz.isAnnotationPresent(Table.class);
		if (!tableExist) {
			return null;		//如果不存在,程序终止
		}
		//获取注解对象
		Table table = (Table) clazz.getAnnotation(Table.class);
		//获取注解对象中的值
		String tableName = table.value();
		//拼写SQL语句
		sql.append(" select * from ").append( tableName ).append(" where 1=1 ");
		//遍历所有的属性
		Field[] files = clazz.getDeclaredFields();
		for (Field field : files) {
			//是够该字段上有相应的注解
			boolean columnExist = field.isAnnotationPresent(Column.class);
			if (columnExist) {
				//获得字段对象上的注解信息,表字段信息
				Column column = field.getAnnotation(Column.class);
				String columnName = column.value();
				//获得字段封装的get方法的值
				String fileName = field.getName();
				//获得各种get方法		get + 首字母大写  + 剩下部分
				String getMethodName = "get"+fileName.substring(0, 1).toUpperCase()+fileName.substring(1);
				//传入方法名,完成对方法的获取
				Method getMethod = clazz.getMethod(getMethodName);
				//传入反射对象,参数,执行对应方法.返回值可以为date,string,int...  
				Object fieldValue = getMethod.invoke(user);		//静态方法,需要在调用前进行实例化
				
				//拼装SQL	如果字段值为空	或者为数字0(首先强转为数字型,随后取值判断)
				if(fieldValue == null || (fieldValue instanceof Integer  && (Integer)fieldValue ==0)){
					continue;
				}
				if(fieldValue == null || (fieldValue instanceof Integer  && (Integer)fieldValue !=0)){
					sql.append(" and ").append(columnName).append(" = ").append(fieldValue);
				}
				//拼装SQL,如果是String类型,则增加"\'"或者in条件
				if(fieldValue instanceof String){
					//强制转为String类型,如果包含,则认为in型的包含查询
					if (((String)fieldValue).contains(",")) {
						//根据分号分隔,追加"\'".
						String[] ins = ((String)fieldValue).split(",");
						sql.append(" and ").append(columnName).append(" in (");
						for (String s : ins) {
							sql.append("\'"+s+"\'"+",");
						}
						sql.deleteCharAt(sql.length()-1);	//删除最后一个
						sql.append(")");
					}else {
						sql.append(" and ").append(columnName).append(" = ").append("\'"+fieldValue+"\'");
					}
				}
			}
		}
		//获取注解后判断条件进行追加SQL
		return sql.toString();
	}
```
### 测试方法
为Bean中传入属性值,执行其解析方法,生成查询SQL语句.
``` java
public static void main(String[] args) throws Exception{

	/*定义查询条件*/
	User user1 = new User();
	user1.setId(10);

	User user2 = new User();
	user2.setUsername("张三");

	User user3 = new User();
	user3.setId(20);
	user3.setEmail("123@qq.com,456@qq.com,789@qq.com");

	/*传入对象,生成SQL语句*/
	String sql1 = query(user1);
	System.out.println(sql1);
	String sql2 = query(user2);
	System.out.println(sql2);
	String sql3 = query(user3);
	System.out.println(sql3);
}
```
