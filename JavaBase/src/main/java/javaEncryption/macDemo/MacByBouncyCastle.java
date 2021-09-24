package javaEncryption.macDemo;

import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

/**
 * 使用BouncyCastle实现MAC消息摘要
 *
 * @author Jion
 */
public class MacByBouncyCastle {

    public static void main(String[] args) throws Exception {
        //明文
        String source = "我是明文:Jion123";

        //加密
        HMac hMac = new HMac(new MD5Digest());
        hMac.init(new KeyParameter(Hex.decode("aaaaaaaaaa")));
        hMac.update(source.getBytes(), 0, source.getBytes().length);
        byte[] bytes = new byte[hMac.getMacSize()];
        hMac.doFinal(bytes, 0);
        String encodeString = new String(Hex.encode(bytes));
        System.out.println("密文:" + encodeString);
    }
}
