package javaEncryption.mdDemo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;


/**
 * 	使用Bouncy Castle提供的Md消息加密算法
 * */
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
