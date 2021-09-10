package javaEncryption.rsaDemoTwo;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

/**	
 * 	使用RSA实现数字签名
 */	
public class RsaByJDK {

	public static void main(String[] args) throws Exception{
		
		//明文
		String source = "我是明文:Jion123";
		
		//初始化秘钥
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(512);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
		
		//执行签名
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());	//私钥签名
		KeyFactory keyFactory  = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initSign(privateKey); 		//初始化
		signature.update(source.getBytes());
		byte[] encodeByte = signature.sign();	//执行签名
		String encodeString = Hex.encodeHexString(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//验证签名
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		signature = Signature.getInstance("MD5withRSA");
		signature.initVerify(publicKey);		//验证签名
		signature.update(source.getBytes());
		boolean result = signature.verify(encodeByte);
		System.out.println("验证结果是:"+result);
	}
}
