package javaEncryption.pbeDemo;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Hex;


/**	
 * 	使用PBE完成对称加密算法
 * */
public class PbeByJDK {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//初始化盐,作为扰码
		SecureRandom random = new SecureRandom();
		byte[] salt = random.generateSeed(8);	//8位的随机字符
		
		//加密,初始化口令,生成秘钥
		String password = "Jion";
		PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");	//使用md5结合des加密
		Key key = factory.generateSecret(pbeKeySpec);
		
		//加密
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 10);	//传入盐和迭代的次数,完成初始化
		Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
		cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
		byte[] encodeByte = cipher.doFinal(source.getBytes());
		String encodeString = Hex.encodeHexString(encodeByte);		//字节数组->十六进制字符数组->字符串
		System.out.println("密文:"+encodeString);
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
		byte[] decodebyte = cipher.doFinal(Hex.decodeHex(encodeString.toCharArray()));	//字符串->十六进制字符数组->字节数组
		String decodeString = new String(decodebyte);
		System.out.println("明文:"+decodeString);
	}
}
