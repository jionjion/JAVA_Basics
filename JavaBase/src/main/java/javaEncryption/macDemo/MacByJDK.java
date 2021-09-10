package javaEncryption.macDemo;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * 	使用JDK实现MAC消息摘要*/
public class MacByJDK {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//生成秘钥
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();	//产生秘钥	
		byte[] key = secretKey.getEncoded();	//获得秘钥
		
		//加密
		SecretKey restoreSercreKey = new SecretKeySpec(key, "HmacMD5");//还原秘钥
		Mac mac = Mac.getInstance(restoreSercreKey.getAlgorithm());	//实例化MAC
		mac.init(restoreSercreKey);	//初始化Mac
		byte[] hmacMD5Byte = mac.doFinal(source.getBytes());	//执行摘要
		String encodeString = Hex.encodeHexString(hmacMD5Byte);
		System.out.println("密文:"+encodeString);
	}
}
