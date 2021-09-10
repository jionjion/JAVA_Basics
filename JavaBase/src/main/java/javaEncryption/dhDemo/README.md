---
title : JAVA中对非对称加密算法DH
tags : JDK8 , Eclipse 
---

[TOC]

---

# 简介
非对称加密算法DH的实现

## 文件列表

- `DhByJDk.java`                          JDK实现DH非对称加密算法

## JDK实现DH非对称加密算法

``` java
public class DhByJDK {

	public static void main(String[] args) throws Exception {
		//明文
		String source = "我是明文:Jion123";
		
		//初始化发送方的公钥
		KeyPairGenerator senderkeyPairGenerator = KeyPairGenerator.getInstance("DH");	//传入加密算法
		senderkeyPairGenerator.initialize(512);		//设置秘钥长度
		KeyPair senderKeyPair = senderkeyPairGenerator.generateKeyPair();		//生成秘钥对
		byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();		//获得公钥,发送给接收方,生成解密私钥
		
		//初始化接收方的秘钥
		KeyFactory receiverKeyFactory = KeyFactory.getInstance("DH");
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc);	//传入发送方的公钥,生成接收方的私钥
		PublicKey receiverPublicKey = receiverKeyFactory.generatePublic(x509EncodedKeySpec);//接收方的公钥
		DHParameterSpec dhParameterSpec = ((DHPublicKey)receiverPublicKey).getParams();		//获得公钥参数
		KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");		//创建接收方的秘钥对
		receiverKeyPairGenerator.initialize(dhParameterSpec);	//从发送方的参数中初始化接收方的秘钥对
		KeyPair receiverKeypair = receiverKeyPairGenerator.generateKeyPair();	//创建接收方的秘钥对
		PrivateKey reciverPrivateKey = receiverKeypair.getPrivate();	//创建接收的私钥
		byte[] reciverPublicKeyEnc = receiverKeypair.getPublic().getEncoded();	//创建接收方的公钥
		
		//秘钥构建
		KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance("DH");
		receiverKeyAgreement.init(reciverPrivateKey);	//传入私钥
		receiverKeyAgreement.doPhase(receiverPublicKey, true);
		SecretKey receiverDesKey = receiverKeyAgreement.generateSecret("DES");	//生成接收方的秘钥对
		
		
		KeyFactory senderKeyFactor = KeyFactory.getInstance("DH");	//创建发送方
		x509EncodedKeySpec = new X509EncodedKeySpec(reciverPublicKeyEnc);	//获得发送方的秘钥空间
		PublicKey senderPublicKey = senderKeyFactor.generatePublic(x509EncodedKeySpec);
		KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");
		senderKeyAgreement.init(senderKeyPair.getPrivate());
		senderKeyAgreement.doPhase(senderPublicKey, true);
		
		SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES");
		if (Objects.equals(receiverDesKey, senderDesKey)) {
			System.out.println("双方秘钥相同.......");
		}
		
		//加密
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
		byte[] encodeByte = cipher.doFinal(source.getBytes());
		String encodeString = Base64.encodeBase64String(source.getBytes());
		System.out.println("密文:"+encodeString);
		
		//解密
		cipher.init(Cipher.DECRYPT_MODE, senderDesKey);
		byte[] decodeByte = cipher.doFinal(encodeByte);
		String decodeString = new String(decodeByte);
		System.out.println("明文:"+decodeString);
		
	}
}
```
