package javaEncryption.base64Demo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 	通过JDK实现Base64的加解密
 * 	*/
public class Base64ByJDK {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		BASE64Encoder encoder = new BASE64Encoder();
		byte[] encodeByte =  source.getBytes();
		String encodeString = encoder.encode(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//解密
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodeByte = decoder.decodeBuffer(encodeString);
		String decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
		
	}
}
