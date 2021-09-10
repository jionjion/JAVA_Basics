---
title : JAVA中对非对称加密算法RSA
tags : JDK8 , Eclipse 
---

[TOC]

---

# 简介
非对称加密算法RSA的实现

## 文件列表

- `RsaByJDk.java`                          JDK实现RSA非对称加密算法

## JDK实现RSA非对称加密算法

``` java
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
```
