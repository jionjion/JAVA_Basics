package javaEncryption.ecdsaDemo;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * 	使用ECDSA实现数字签名	
 * */
public class EcdsaByJDK {

	public static void main(String[] args) throws Exception{
		
		//明文
		String source = "我是明文:Jion123";
		
		//初始化秘钥
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
		keyPairGenerator.initialize(256);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		ECPublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
		ECPrivateKey ecPrivateKey = (ECPrivateKey) keyPair.getPrivate();
		
		//执行签名
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());	//私钥签名
		KeyFactory keyFactory  = KeyFactory.getInstance("EC");
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance("SHA1withECDSA");
		signature.initSign(privateKey); 		//初始化
		signature.update(source.getBytes());
		byte[] encodeByte = signature.sign();	//执行签名
		String encodeString = Hex.encodeHexString(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//验证签名
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance("EC");
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		signature = Signature.getInstance("SHA1withECDSA");
		signature.initVerify(publicKey);		//验证签名
		signature.update(source.getBytes());
		boolean result = signature.verify(encodeByte);
		System.out.println("验证结果是:"+result);
	}
}
