package lomback;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;

/**
 * @author Jion
 *  \@SneakyThrows  将当前编译时异常转为运行时异常,在运行时抛出而不是编码时.
 *      但是这样不好,接口调用者不知道有哪些可能异常.
 */
public class SneakyThrowsAnnotateExample {

    @SneakyThrows({FileNotFoundException.class, IOException.class})
    private void read(){

        File file = new File("XX");
        InputStream inputStream = new FileInputStream(file);
        inputStream.close();
    }

    @Test
    public void testRead(){
        // 运行时抛出 FileNotFoundException , IOException
        read();
    }
}
