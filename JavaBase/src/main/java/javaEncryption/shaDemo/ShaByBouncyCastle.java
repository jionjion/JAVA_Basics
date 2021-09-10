package javaEncryption.shaDemo;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.util.encoders.Hex;
/**
 * 	通过BouncyCastle实现消息摘要加密
 * */
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
