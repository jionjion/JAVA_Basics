package javaEail.service;

import javaEail.bean.User;
import javaEail.dao.EmailDao;
import javaEail.until.EmailUntil;

/**服务层*/
public class EmailService {

	/**将数据存入到数据库,同时发送邮件*/
	public static void regist(User user) {
		EmailDao dao = new EmailDao();
		dao.regist(user);
		EmailUntil.sendEmail(user.getEmail(), user.getCode());
	}
}
