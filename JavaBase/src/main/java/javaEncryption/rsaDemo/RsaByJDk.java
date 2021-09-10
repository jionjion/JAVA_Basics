package javaEncryption.rsaDemo;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**使用JDK自带的完成RSA非对称加密*/
public class RsaByJDk {

	public static void main(String[] args) throws Exception {
		
		//明文
		String source = "我是明文:Jion123";
		
		//初始化秘钥
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(512);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();		//获得公钥
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();	//获得私钥
		
		/*使用私钥加密公,钥解密方式*/
		//私钥加密
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] encodeByte = cipher.doFinal(source.getBytes());
		String encodeString = Base64.encodeBase64String(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//公钥解密
		X509EncodedKeySpec x509EncodedKeySpec = new  X509EncodedKeySpec(rsaPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] decodeByte = cipher.doFinal(Base64.decodeBase64(encodeString));
		String decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
		
		/*使用公钥加密.私钥解密方式*/
		//公钥加密
		x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance("RSA");
		publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		encodeByte = cipher.doFinal(source.getBytes());
		encodeString = Base64.encodeBase64String(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//私钥解密
		pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
		keyFactory = KeyFactory.getInstance("RSA");
		privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		decodeByte = cipher.doFinal(Base64.decodeBase64(encodeString));
		decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
	}
}
