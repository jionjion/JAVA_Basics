---
title : JAVA中消息摘要算法MAC
tags : JDK8 , Eclipse 
---

[TOC]

---

# 简介
消息摘要算法MAC的实现

## 文件列表

- `MacByBouncyCastle.java`          Bouncy Castle实现MAC消息摘要
- `MacByJDK.java`                          JDK实现MAC消息摘要

## JDK实现MAC消息摘要

``` java
public class MacByJDK {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//生成秘钥
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();	//产生秘钥	
		byte[] key = secretKey.getEncoded();	//获得秘钥
		
		//加密
		SecretKey restoreSercreKey = new SecretKeySpec(key, "HmacMD5");//还原秘钥
		Mac mac = Mac.getInstance(restoreSercreKey.getAlgorithm());	//实例化MAC
		mac.init(restoreSercreKey);	//初始化Mac
		byte[] hmacMD5Byte = mac.doFinal(source.getBytes());	//执行摘要
		String encodeString = Hex.encodeHexString(hmacMD5Byte);
		System.out.println("密文:"+encodeString);
	}
}
```


## 	BouncyCastle实现MAC消息摘要

``` java
public class MacByBouncyCastle {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		HMac hMac = new HMac(new MD5Digest());
		hMac.init(new KeyParameter(Hex.decode("aaaaaaaaaa")));
		hMac.update(source.getBytes(),0,source.getBytes().length);
		byte[] hmacMD5Byte = new byte[hMac.getMacSize()];
		hMac.doFinal(hmacMD5Byte, 0);
		String encodeString = new String(Hex.encode(hmacMD5Byte));
		System.out.println("密文:"+encodeString);
	}
}
```
