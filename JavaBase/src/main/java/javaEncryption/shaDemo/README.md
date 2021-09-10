---
title : JAVA中消息摘要算法SHA
tags : JDK8 , Eclipse 
---

[TOC]

---

# 简介
消息摘要算法SHA的实现

## 文件列表

- `ShaByBouncyCastle.java`                  BouncyCastle实现消息摘要加密
- `ShaByCommonsCodec.java`              CommonsCodec实现消息摘要算法
- `ShaByJDK.java`                                  JDK实现SHA消息摘要


## JDK实现SHA消息摘要

``` java
public class ShaByJDK {

	public static void main(String[] args) throws Exception{
		
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		MessageDigest messageDigest = MessageDigest.getInstance("SHA");
		messageDigest.update(source.getBytes());
		byte[] encodeByte = messageDigest.digest();
		String encodeString = Hex.encodeHexString(encodeByte);
		System.out.println("密文:"+encodeString);
	}
}
```

## BouncyCastle实现消息摘要加密

``` java
public class ShaByBouncyCastle {

	public static void main(String[] args) throws Exception{
		
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		Digest digest = new SHA1Digest();
		digest.update(source.getBytes(),0,source.getBytes().length);
		byte[] encodeByte = new byte[digest.getDigestSize()];
		digest.doFinal(encodeByte, 0);
		String encodeString = new String(Hex.encode(encodeByte));
		System.out.println("密文:"+encodeString);
	}
}
```

## CommonsCodec实现消息摘要算法

``` java
public class ShaByCommonsCodec {

	public static void main(String[] args) {
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		String encodeString = DigestUtils.sha256Hex(source.getBytes());
		System.out.println("密文:"+encodeString);
	}
}
```


