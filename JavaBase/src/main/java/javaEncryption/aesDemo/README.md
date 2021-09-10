---
title : JAVA中对称加密算法AES
tags : JDK8 , Eclipse 
---

[TOC]

---

# 简介
对称加密算法AES的实现

## 文件列表

- `AesByBouncyCastle.java`          Bouncy Castle实现AES对称加密算法
- `AesByJDK.java`                          JDK实现AES对称加密算法
- 

## JDK实现AES对称加密算法

``` java
public class AesByJDK {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//生成key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] keyByte = secretKey.getEncoded();
		
		//生产对称秘钥
		Key key = new SecretKeySpec(keyByte, "AES");
		
		//加密
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");	//加密算法/加密方式/填充方式
		cipher.init(Cipher.ENCRYPT_MODE, key); 	//加密工作,使用对称秘钥
		byte[] encodeByte = cipher.doFinal(source.getBytes());	//加密,生成字节数组
		String encodeString = Hex.encodeHexString(encodeByte);	//字节数组->十六进制字符 ->字符串
		System.out.println("密文:"+encodeString);
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, key);	//解密工作,使用对称秘钥
		byte[] decodeByte = cipher.doFinal(Hex.decodeHex(encodeString.toCharArray()));// 字符串->十六进制字符->字节数组
		String decodeString = new String(decodeByte);			//将数组转为字符串
		System.out.println("明文:"+decodeString);
		
	}
}
```

##  Bouncy Castle实现AES对称加密算法

``` java
public class AesByBouncyCastle {

	public static void main(String[] args) throws Exception {
		//明文
		String source = "我是明文:Jion123";
		
		//动态增加加密方式
		Security.addProvider(new BouncyCastleProvider());
		
		//生成key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES","BC");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] keyByte = secretKey.getEncoded();
		
		//生产对称秘钥
		Key key = new SecretKeySpec(keyByte, "AES");
		
		//加密
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");	//加密算法/加密方式/填充方式
		cipher.init(Cipher.ENCRYPT_MODE, key); 	//加密工作,使用对称秘钥
		byte[] encodeByte = cipher.doFinal(source.getBytes());	//加密,生成字节数组
		String encodeString = Hex.encodeHexString(encodeByte);	//字节数组->十六进制字符 ->字符串
		System.out.println("密文:"+encodeString);
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, key);	//解密工作,使用对称秘钥
		byte[] decodeByte = cipher.doFinal(Hex.decodeHex(encodeString.toCharArray()));// 字符串->十六进制字符->字节数组
		String decodeString = new String(decodeByte);			//将数组转为字符串
		System.out.println("明文:"+decodeString);
	}
}
```


