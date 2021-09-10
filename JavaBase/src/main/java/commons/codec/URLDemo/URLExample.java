package commons.codec.URLDemo;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

/**
 *  对URL进行编码
 * */
public class URLExample {


    /**
     *  将URL进行编码
     */
    @Test
    public void testEncode() throws EncoderException {

        URLCodec urlCodec = new URLCodec();
        String result = urlCodec.encode("name=囧囧");
        System.out.println(result);
    }

    /**
     *  将URL进行解码
     */
    @Test
    public void testDecode() throws DecoderException {
        URLCodec urlCodec = new URLCodec();
        String result = urlCodec.decode("%3Fname%3D%E5%9B%A7%E5%9B%A7");
        System.out.println(result);
    }
}
