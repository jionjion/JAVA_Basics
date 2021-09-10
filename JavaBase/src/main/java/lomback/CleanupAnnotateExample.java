package lomback;

import lombok.Cleanup;
import org.junit.Test;

import java.io.*;

/**
 * @author Jion
 *  \@close 注解,用于安全释放连接等.默认调用value中的方法
 */
public class CleanupAnnotateExample {

    public String readBook(String src) throws IOException {

        @Cleanup
        InputStream in = new FileInputStream(new File(src));
        @Cleanup(value = "close")
        InputStreamReader reader = new InputStreamReader(in);

        StringBuilder stringBuilder = new StringBuilder();
        char[] c = new char[10000];

        while (true) {
            int r = reader.read(c);
            if (r == -1) {
                break;
            }
            stringBuilder.append(new String(c));
        }
        return stringBuilder.toString();
    }

    @Test
    public void testReadBook() throws IOException {
        String result = readBook("F:\\JAVA_WorkSpace\\JavaBase\\src\\lomback\\README.md");
        System.out.println(result);
    }
}
