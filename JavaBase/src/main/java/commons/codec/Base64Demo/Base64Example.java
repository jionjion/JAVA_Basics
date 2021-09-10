package commons.codec.Base64Demo;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.util.Arrays;

/**
 *  使用Base64编码解码
 */
public class Base64Example {

    /**
     *  测试类,将字符串转为Base64字符串
     */
    @Test
    public void testEncodeToString(){
        Base64 base64 = new Base64();
        String result = base64.encodeToString("明文...".getBytes());
        System.out.println(result);
    }

    /**
     *  测试类,将字符串转为Base64字节数组
     */
    @Test
    public void testEncodeToByteArray(){
        Base64 base64 = new Base64();
        byte[] result = base64.encode("明文...".getBytes());
        System.out.println(Arrays.toString(result));
        
    }

    /**
     *  测试类,解码Base64字符串
     */
    @Test
    public void testDecodeToByteArray() {
        Base64 base64 = new Base64();
        byte[] bytes = base64.decode("5piO5paHLi4u");
        String result = new String(bytes);
        System.out.println(result);
    }
}
