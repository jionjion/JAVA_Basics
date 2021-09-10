---
title : JAVA中Base64编码
tags : JDK8 , Eclipse 
---

[TOC]

---

## 简介
使用Base64算法完成敏感字段的加解密.


## 文件

`Base64ByBouncyCastle.java`     使用Bouncy Castle实现Base64的加解密
`Base64ByCommonsCodec.java`使用Commons Codec实现Base64的加解密
`Base64ByJDK.java`                    使用JDK实现Base64的加解密


## 使用JDK实现Base64的加解密

``` java
public class Base64ByJDK {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		BASE64Encoder encoder = new BASE64Encoder();
		byte[] encodeByte =  source.getBytes();
		String encodeString = encoder.encode(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//解密
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodeByte = decoder.decodeBuffer(encodeString);
		String decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
		
	}
}
```


##  使用Commons Codec实现Base64的加解密

``` java
public class Base64ByCommonsCodec {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		byte[] encodeByte   = Base64.encodeBase64(source.getBytes());
		String encodeString = new String(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//解密
		byte[] decodeByte = Base64.decodeBase64(encodeString);
		String decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
		
	}
}
```

## 使用Bouncy Castle实现Base64的加解密

``` java
public class Base64ByBouncyCastle {

	public static void main(String[] args) throws Exception{
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		byte[] encodeByte   = Base64.encode(source.getBytes());
		String encodeString = new String(encodeByte);
		System.out.println("密文:"+encodeString);
		
		//解密
		byte[] decodeByte = Base64.decode(encodeString);
		String decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
		
	}
}
```
