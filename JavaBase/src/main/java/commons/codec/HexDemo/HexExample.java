package commons.codec.HexDemo;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;


/**
 *  十六进制编码解码
 */
public class HexExample {

    /**
     *  UTF-8编码,将字符串编码为字节数组
     */
    @Test
    public void testEncodeToByteArray() throws UnsupportedEncodingException {
        Hex hex = new Hex();
        byte[] bytes = hex.encode("明文...".getBytes("UTF-8"));
        System.out.println(Arrays.toString(bytes));
    }

    /**
     *  UTF-8编码,将字符串转为字节数组对应的十六进制进行输出
     */
    @Test
    public void testEncodeToString() throws UnsupportedEncodingException {
        Hex hex = new Hex();
        String result = hex.encodeHexString("明文".getBytes("UTF-8"));
        System.out.println(result);
    }

    /**
     *  解码,将字符串转为明文的字节数组
     */
    @Test
    public void testDecodeToByteArray() throws UnsupportedEncodingException, DecoderException {
        Hex hex = new Hex();
        byte[] bytes = hex.decode("e6988ee69687".getBytes("UTF-8"));
        String result = new String(bytes);
        System.out.println(result);
    }
}
