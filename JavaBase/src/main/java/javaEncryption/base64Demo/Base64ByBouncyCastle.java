package javaEncryption.base64Demo;

import org.bouncycastle.util.encoders.Base64;

/**
 * 	通过BouncyCastle实现Base64的加解密
 * 	*/
public class Base64ByBouncyCastle {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		byte[] encodeByte   = Base64.encode(source.getBytes());
		String encodeString = new String(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//解密
		byte[] decodeByte = Base64.decode(encodeString);
		String decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
		
	}
}
