package javaEncryption.mdDemo;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 	通过Commons Codec方式,实现MD消息摘要加密
 * 	*/
public class MdByCommonsCodec {

	public static void main(String[] args) {
		//明文
		String source = "我是明文:Jion123";
		
		//加密
		String md4String = DigestUtils.md5Hex(source);
		System.out.println("密文:"+md4String);
		
	}
}
