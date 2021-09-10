package javaEncryption.base64Demo;

import org.apache.commons.codec.binary.Base64;

/**
 * 	通过CommonsCodec实现Base64的加解密
 * 	*/
public class Base64ByCommonsCodec {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		byte[] encodeByte   = Base64.encodeBase64(source.getBytes());
		String encodeString = new String(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//解密
		byte[] decodeByte = Base64.decodeBase64(encodeString);
		String decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
		
	}
}
