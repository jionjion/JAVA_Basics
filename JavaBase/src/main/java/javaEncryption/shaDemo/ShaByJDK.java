package javaEncryption.shaDemo;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

/**
 * 	通过JDK的方式实现SHA消息摘要*/
public class ShaByJDK {

	public static void main(String[] args) throws Exception{
		
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		MessageDigest messageDigest = MessageDigest.getInstance("SHA");
		messageDigest.update(source.getBytes());
		byte[] encodeByte = messageDigest.digest();
		String encodeString = Hex.encodeHexString(encodeByte);
		System.out.println("密文:"+encodeString);
	}
}
