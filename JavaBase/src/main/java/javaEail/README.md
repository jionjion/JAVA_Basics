---
title: JAVA中邮件服务
tags: JDK8, Eclipse, javamail
---

[TOC]

---

## 简介
以`javamail`代码调用QQ邮件服务,实现基于JAVA的简单邮件发送.这里模拟用户注册时服务器向用户邮箱发送UUID,随后用户可以携带UUID验证访问完成注册.

## 相关知识
### 邮件的发送协议:

 - SMTP协议,简单邮件传送协议其默认端口号25
 - POP3协议:邮局协议3其默认端口号110

### 邮件的发送过程:
首先是客户端发送邮件到邮箱服务器(SMTP)中,随后邮件发送到对方邮件服务器(SMTP),随后通过(POP3)服务器最终将邮件发送给对方


## 包结构

* `bean`  封装对象模型
* `control` 访问控制层,分发浏览器请求,调用服务层
* `dao` 数据持久化层,实现与数据库交互
* `service` 业务服务层,编写业务逻辑,调用数据持久化层或者工具类
* `until` 包含各种工具类

## 子包描述
### `bean`包
包含一个`User`类,里面封装了用户模型类的属性,其中`code`属性为将来验证邮箱时交由客户端携带验证的哈希码.

``` java
public class User {
	//用户ID
	private int uid;
	//用户名
	private String username;
	//账号密码
	private String password;
	//账号昵称
	private String nickname;
	//邮箱
	private String email;
	//账号状态
	private int state;
	//验证hash
	private String code;
......	
}	
```

### `dao`包
包含`EmailDao`类,将用户填写的个人信息保存在`mysql`数据库中,这里使用`until`包下的`getConnect`方法获得数据库JDBC连接.
这里使用预编译的SQL语句,将调用者传入的`user`对象属性进行持久化为数据库中的对应表.

``` java
/**将业务表同步到数据库中*/
public class EmailDao {
	/**保存用户数据的*/
	public void regist(User user){
		try {
			String sql = " insert into userEmail value (?,?,?,?,?,?,?) ";
			Connection connection = Until.getConnect();
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
```

### `service`包
业务逻辑层,包含`EmailService`类,该类调用`EmailDao`类中的`regist`方法持久化对象数据和`EmailUntil`包下的`sendEmail`方法发送电子邮件.

``` java
public class EmailService {
	/**将数据存入到数据库,同时发送邮件*/
	public static void regist(User user) {
		EmailDao dao = new EmailDao();
		dao.regist(user);
		EmailUntil.sendEmail(user.getEmail(), user.getCode());
	}
}
```

### `control`包
模拟接收用户请求,从请求参数中获得用户信息,同时调用`until`工具包的`UUIDUntil`类生成哈希码,一起封装为一个`user`对象,最后调用`service`层完成业务逻辑.

``` java
/**页面注册的类,模拟接收前台传递的参数*/
public class EmailControl {

	@Test
	public void doGet() {
		String username = "张谦";
		String password = "123456";
		String nickname = "JION";
		String email = "2890283899@qq.com";
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setNickname(nickname);
		user.setState(0);							//	0:未激活	1:已激活
		user.setCode(new UUIDUntil().getUUID());	//	随机验证码
		
		//调用Service层,的注册方法
		EmailService.regist(user);
	}
}
```

### `until`包
工具类,包含了各种工具类.

 - `ConnectUntil`类  获取数据库JDBC连接
 - `UUIDUntil`类  随机生成UUID字符串
 - `EmailUntil`类  发送各种电子邮件


#### `ConnectUntil`类
使用jdbc获得MySQL数据库的`Connet`对象.
``` java
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
```

#### `UUIDUntil`类
随机生成一组UUID.

``` java
/**随机生成UUID无序数字*/
public class UUIDUntil {

	public String getUUID() {
		UUID uuid = UUID.randomUUID();			//72cf6662-f5de-4450-b3c2-0fd32536ef4e
		String id = uuid.toString().replace("-", "");
		System.out.println(id);					//d74f5f91241241a787984507d059c302
		return id;
	}
}
```

#### `UUIDUntil`类
实现了通过JAVA代码调用QQ的SMTP邮件服务完成邮寄功能.

 - 设置QQ邮箱允许POP3/SMTP服务和IMAP/SMTP服务
 - 生成QQ邮箱的授权码
 - 设置服务配置
 - 填写发送人,接收人,主题,内容,附件等...
 - 执行发送

``` java
/**邮件的工具类*/
public class EmailUntil {

	/**将发件人的Email地址传进去,以及UUD传入,完成验证*/
	public static void sendEmail(String to ,String code) {
		
		try {
			//创建连接对象
			//创建配置服务信息
			//QQ邮箱的授权码  lulyxaugngsfhhad
			Properties props = new Properties();
			// 开启debug调试
			props.setProperty("mail.debug", "true");
			// 发送服务器需要身份验证
			props.setProperty("mail.smtp.auth", "true");
			// 设置邮件服务器主机名
			props.setProperty("mail.host", "smtp.qq.com");
			// 发送邮件协议名称
			props.setProperty("mail.transport.protocol", "smtp");
			
			//SSH加密协议
		    MailSSLSocketFactory sf = new MailSSLSocketFactory();
		    sf.setTrustAllHosts(true);
		    props.put("mail.smtp.ssl.enable", "true");
		    props.put("mail.smtp.ssl.socketFactory", sf);
		    
			Session session = Session.getInstance(props);
			//创建邮件对象
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("1434501783@qq.com"));			//发件人
			message.setRecipient(RecipientType.TO, new InternetAddress(to));	//发送类型,收件人	
			message.setSubject("主题:这是我的JAVA测试邮件");							//设置邮件主题
			String html = "	<h1>你好,很高兴认识你</hi><p>您的UUID为:"+code+"</p>";		//设置邮件内容
			message.setContent(html, "text/html;charset=UTF-8");				//设置邮件文本格式
			
		//发送邮件
			Transport transport = session.getTransport();
	        transport.connect("smtp.qq.com", "1434501783@qq.com", "lulyxaugngsfhhad");					//获取连接(连接方式,发送人邮箱,发送人密码)
	        transport.sendMessage(message, new Address[] { new InternetAddress(to) });	//以列表形式发送邮件.群发
	        transport.close();
		} catch (Exception e) {
			System.err.println("创建邮件服务发生意外.....");
			e.printStackTrace();
		}
	}
}
```
