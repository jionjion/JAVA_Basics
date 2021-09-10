package javaEncryption.mdDemo;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

/**
 *	使用JDK自带的MD5实现消息摘要加密
 *
 */
public class MdByJDK {

	public static void main(String[] args) throws Exception {
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");	//也可以使用MD2
		byte[] md5Byte = messageDigest.digest(source.getBytes());
		String md5String = Hex.encodeHexString(md5Byte);	//直接转为十六进制
		System.out.println("密文:"+md5String);
		
		//置空
		md5Byte = null;
	}
}
