---
title : JAVA中消息摘要算法MD
tags : JDK8 , Eclipse 
---

[TOC]

---

## 简介
消息摘要算法中MD的实现


## 文件

- `MdByBouncyCastle.java`  使用Bouncy Castle提供的Md消息加密算法
- `MdByCommonsCodec.java`  
- `MdByJDK.java`

## JDK自带的MD5实现消息摘要加密

``` java
public class MdByJDK {

	public static void main(String[] args) throws Exception {
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");	//也可以使用MD2
		byte[] md5Byte = messageDigest.digest(source.getBytes());
		String md5String = Hex.encodeHexString(md5Byte);	//直接转为十六进制
		System.out.println("密文:"+md5String);
		
		//置空
		md5Byte = null;
	}
}
```


## Bouncy Castle提供的Md消息摘要加密

``` java
public class MdByBouncyCastle {

	public static void main(String[] args) throws Exception{
		
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		Digest digest = new MD4Digest();	//直接创建对象
		digest.update(source.getBytes() , 0, source.getBytes().length);	//对输入内容进行加密
		byte[] md4Byte = new byte[digest.getDigestSize()]; 
		digest.doFinal(md4Byte, 0);		//对加密后的进行输出
		md4Byte = Hex.encode(md4Byte);	//格式化字节数组
		System.out.println("密文:"+ (new String(md4Byte)));	//将字节数组转为String输出
		
		//解密
		
		
	}
	
	
	
	/**通过动态为JDK添加方式*/
	@Test
	public void dynamicAdd() {
		
		try {
			//密文
			String source = "我是明文:Jion123";
			
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest messageDigest = MessageDigest.getInstance("MD4");
			byte[] md5Byte = messageDigest.digest(source.getBytes());
			System.out.println("密文:"+new String(Hex.encode(md5Byte)));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.err.println("消息加密中出现意外....");
		}
	}
	
}
```


## Commons Codec提供的MD消息摘要加密

``` java
public class MdByCommonsCodec {

	public static void main(String[] args) {
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		String md4String = DigestUtils.md5Hex(source);
		System.out.println("密文:"+md4String);
		
	}
}
```
