package commons.codec.MD5Demo;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 *  MD5加解密
 */
public class MD5Example {

    /**
     * 测试MD5加密,并将结果转为Hex16进制字符串
     */
    @Test
    public void testMd5HexString() {
        String result = DigestUtils.md5Hex("密文...");
        System.out.println(result);
    }

    /**
     *  测试MD5加密,将结果转为字节数组
     */
    @Test
    public void testMD5ByteArray(){
        byte[] result = DigestUtils.md5("密文...");
        System.out.println(Arrays.toString(result));
    }
}
