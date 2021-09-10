package javaEncryption.des3Demo;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * 	通过JDK自带的实现对称加密
 * 	*/
public class Des3ByJDK {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//生成key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
//		keyGenerator.init(168);	//使用168位的长度
		keyGenerator.init(new SecureRandom());	//默认长度的key,根据加密方式确定长度
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] keyByte = secretKey.getEncoded();
		
		//生产对称秘钥
		DESedeKeySpec desedeKeySpec = new DESedeKeySpec(keyByte);	//秘钥空间
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");	//秘钥工厂
		Key  symmetrySecretKey = factory.generateSecret(desedeKeySpec);	//生成秘钥
		
		//加密
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");	//加密算法/加密方式/填充方式
		cipher.init(Cipher.ENCRYPT_MODE, symmetrySecretKey); 	//加密工作,使用对称秘钥
		byte[] encodeByte = cipher.doFinal(source.getBytes());	//加密,生成字节数组
		String encodeString = Hex.encodeHexString(encodeByte);	//字节数组->十六进制字符 ->字符串
		System.out.println("密文:"+encodeString);
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, symmetrySecretKey);	//解密工作,使用对称秘钥
		byte[] decodeByte = cipher.doFinal(Hex.decodeHex(encodeString.toCharArray()));// 字符串->十六进制字符->字节数组
		String decodeString = new String(decodeByte);			//将数组转为字符串
		System.out.println("明文:"+decodeString);
		
	}
}
