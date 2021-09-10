---
title : JAVA中数字签名算法DSA
tags : JDK8 , Eclipse 
---

[TOC]

---

# 简介
数字签名算法DSA的实现

## 文件列表

- `DsaByJDK.java`                        JDK实现DSA数字签名算法

##  JDK实现DSA数字签名算法

``` java
public class DsaByJDK {

	public static void main(String[] args) throws Exception{
		
		//明文
		String source = "我是明文:Jion123";
		
		//初始化秘钥
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
		keyPairGenerator.initialize(512);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		DSAPublicKey dsaPublicKey = (DSAPublicKey) keyPair.getPublic();
		DSAPrivateKey dsaPrivateKey = (DSAPrivateKey) keyPair.getPrivate();
		
		//执行签名
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(dsaPrivateKey.getEncoded());	//私钥签名
		KeyFactory keyFactory  = KeyFactory.getInstance("DSA");
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance("SHA1withDSA");
		signature.initSign(privateKey); 		//初始化
		signature.update(source.getBytes());
		byte[] encodeByte = signature.sign();	//执行签名
		String encodeString = Hex.encodeHexString(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//验证签名
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(dsaPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance("DSA");
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		signature = Signature.getInstance("SHA1withDSA");
		signature.initVerify(publicKey);		//验证签名
		signature.update(source.getBytes());
		boolean result = signature.verify(encodeByte);
		System.out.println("验证结果是:"+result);
	}
}
```
