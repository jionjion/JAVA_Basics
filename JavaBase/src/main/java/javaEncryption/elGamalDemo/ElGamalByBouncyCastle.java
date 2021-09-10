package javaEncryption.elGamalDemo;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**使用BouncyCastle的完成EIGaml非对称加密*/
public class ElGamalByBouncyCastle {

	public static void main(String[] args) throws Exception {
		
		//明文
		String source = "Jion123";	//密文最长为12个字符.
		
		//初始化秘钥
		Security.addProvider(new BouncyCastleProvider());
		AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance("ElGamal");
		algorithmParameterGenerator.init(128);
		AlgorithmParameters algorithmParameters = algorithmParameterGenerator.generateParameters();
		DHParameterSpec dhParameterSpec = (DHParameterSpec) algorithmParameters.getParameterSpec(DHParameterSpec.class);
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ElGamal");
		keyPairGenerator.initialize(dhParameterSpec,new SecureRandom());
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		PublicKey elGamlPublicKey = keyPair.getPublic();
		PrivateKey elGamlPrivateKey = keyPair.getPrivate();
		
		//公钥加密
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(elGamlPublicKey.getEncoded());
		KeyFactory keyFactory = KeyFactory.getInstance("ElGamal");
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		Cipher cipher = Cipher.getInstance("ElGamal");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encodeByte = cipher.doFinal(source.getBytes());
		String encodeString = Base64.encodeBase64String(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//私钥解密
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(elGamlPrivateKey.getEncoded());
		keyFactory = KeyFactory.getInstance("ElGamal");
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		cipher = Cipher.getInstance("ElGamal");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decodeByte = cipher.doFinal(Base64.decodeBase64(encodeString));
		String decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
	}
}
