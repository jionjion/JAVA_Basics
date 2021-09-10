package commons.email;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

/**
 * @author JionJion											
 *	使用QQ发送邮件												
 *		主机:		smtp.qq.com
 *		端口		587									
 *		协议:		smtp
 *		授期码:	lulyxaugngsfhhad
 *		这里,使用QQ邮箱,QQ邮箱的发送是采用用户+授权码的形式调用,区别其他使用用户名密码
 */
public class SendQQEmailExample {

	
	/**	发送简单的邮件
	 * 	仅支持文本   */
	@Test
	public void sendSimpleEmail() {
		try {
			//创建简单邮件对象
			SimpleEmail simpleEmail = new SimpleEmail();
			//设置用户名,密码
			simpleEmail.setAuthentication("1434501783@qq.com", "aqwaqxuiztvthadj");
			//设置主机
			simpleEmail.setHostName("smtp.qq.com");
			//设置端口
			simpleEmail.setSmtpPort(587);
			//设置发件人
			simpleEmail.setFrom("1434501783@qq.com", "Jion", "UTF-8");
			//设置收件人
			simpleEmail.addTo("1434501783@qq.com", "Jion", "UTF-8");
			//设置抄送
			simpleEmail.addCc("1434501783@qq.com", "Jion", "UTF-8");
			//设置密送
			simpleEmail.addBcc("1434501783@qq.com", "Jion", "UTF-8");
			//设置主题
			simpleEmail.setSubject("简单的邮件");
			//设置内容
			simpleEmail.setMsg("这是一封简单的邮件!");
			//发送
			simpleEmail.send();
		} catch (EmailException e) {
			e.printStackTrace();
			System.err.println("邮件发送失败!");
		}
	}
	
	/** 发送带有附件的邮件
	 */
	@Test
	public void sendEmailWithAttachment() {
		try {
			//创建附件对象
			EmailAttachment attachment = new EmailAttachment();
			//附件URL,可以为互联网文件
			attachment.setURL(new URL("http:/www.baidu.com/baidu.jpg"));
			String path = System.getProperty("user.dir") + "/src/commons/email/README.md";
			attachment.setPath(path);
			//为附件类型
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			//附件描述
			attachment.setDescription("附件为页面.md文档");
			//附件名,注意后缀格式
			attachment.setName("README.md");
			
			//创建多媒体邮件对象
			MultiPartEmail email = new MultiPartEmail();
			//主机端口
			email.setHostName("smtp.qq.com");
			//认证,QQ邮箱支持SSL连接认证方式
			email.setAuthenticator(new DefaultAuthenticator("1434501783@qq.com", "lulyxaugngsfhhad"));
			//SSL连接
			email.setSSLOnConnect(true);
			//发件人
			email.setFrom("1434501783@qq.com");
			//主题
			email.setSubject("包含附件的邮件");
			//信息
			email.setMsg("这是一封包含附件的邮件!");
			//收件人
			email.addTo("1434501783@qq.com");
			
			//将附件添加
			email.attach(attachment);
			//发送
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			System.err.println("邮件发送失败!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("网络文件获取失败!");
		}
	}
	
	/** 发送具有HTML格式的邮件 */
	@Test
	public void sendEmailWithHtml() {
		try {
			//创建具有图片
			HtmlEmail email = new HtmlEmail();
			//字符集设置
			email.setCharset("UTF-8");
			//主机端口
			email.setHostName("smtp.qq.com");
			//认证,QQ邮箱支持SSL连接认证方式
			email.setAuthenticator(new DefaultAuthenticator("1434501783@qq.com", "lulyxaugngsfhhad"));
			//SSL连接
			email.setSSLOnConnect(true);
			//发件人
			email.setFrom("1434501783@qq.com","Jion","UTF-8");
			//主题
			email.setSubject("HTML格式邮件");
			//收件人
			email.addTo("1434501783@qq.com");		
			
			//图片链接,git图片
			URL url = new URL("https://avatars0.githubusercontent.com/u/24974015");
			//自定义,图片名
			String jion = email.embed(url, "jion logo");
			//html部分 , cid固定语法,表示引用图片
			email.setMsg("<html>你好 <img src=\"cid:"+jion+"\"></html>");
			
			//文字部分
			email.setTextMsg("这是邮件部分,如果你的邮箱不支持HTML则会显示");

			// 发送邮件
			email.send();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("网络图片获取失败!");
		} catch (EmailException e) {
			e.printStackTrace();
			System.err.println("邮件发送失败!");
		}
	} 
	
}
