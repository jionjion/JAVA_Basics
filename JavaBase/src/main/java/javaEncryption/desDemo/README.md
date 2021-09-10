---
title : JAVA中对称加密算法DES
tags : JDK8 , Eclipse 
---

[TOC]

---

# 简介
对称加密算法DES的实现

## 文件列表

- `DesByBouncyCastle.java`          Bouncy Castle实现DES对称加密算法
- `DesByJDK.java`                          JDK实现DES对称加密算法

## JDK实现DES对称加密算法

``` java
public class DesByJDK {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//生成key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		keyGenerator.init(56);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] keyByte = secretKey.getEncoded();
		
		//生产对称秘钥
		DESKeySpec desKeySpec = new DESKeySpec(keyByte);	//秘钥空间
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");	//秘钥工厂
		Key  symmetrySecretKey = factory.generateSecret(desKeySpec);	//生成秘钥
		
		//加密
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");	//加密算法/加密方式/填充方式
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
```


##  Bouncy Castle实现DES对称加密算法

``` java
public class DesByBouncyCastle {

	public static void main(String[] args) throws Exception {
		//明文
		String source = "我是明文:Jion123";
		
		//动态增加加密方式
		Security.addProvider(new BouncyCastleProvider());
		
		//生成key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES","BC");
		keyGenerator.init(56);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] keyByte = secretKey.getEncoded();
		
		//生产对称秘钥
		DESKeySpec desKeySpec = new DESKeySpec(keyByte);	//秘钥空间
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");	//秘钥工厂
		Key  symmetrySecretKey = factory.generateSecret(desKeySpec);	//生成秘钥
		
		//加密
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");	//加密算法/加密方式/填充方式
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
```
