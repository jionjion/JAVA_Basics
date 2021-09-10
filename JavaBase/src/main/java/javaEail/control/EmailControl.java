package javaEail.control;

import org.junit.Test;

import javaEail.bean.User;
import javaEail.service.EmailService;
import javaEail.until.UUIDUntil;

/**页面注册的类,模拟接收前台传递的参数*/
public class EmailControl {

	@Test
	public void doGet() {
		String username = "张谦";
		String password = "123456";
		String nickname = "JION";
		String email = "1434501783@qq.com";
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
