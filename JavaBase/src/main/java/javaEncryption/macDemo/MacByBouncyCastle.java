package javaEncryption.macDemo;

import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

/**
 * 	使用BouncyCastle实现MAC消息摘要
 * 	
 */
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
