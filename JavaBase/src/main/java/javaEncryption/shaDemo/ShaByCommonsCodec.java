package javaEncryption.shaDemo;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 	通过CommonsCodec实现消息摘要算法	
 * */
public class ShaByCommonsCodec {

	public static void main(String[] args) {
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		String encodeString = DigestUtils.sha256Hex(source.getBytes());
		System.out.println("密文:"+encodeString);
	}
}
