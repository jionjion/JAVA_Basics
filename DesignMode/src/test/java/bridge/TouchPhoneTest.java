package bridge;

import org.junit.Test;

/**
 * @author Jion
 */
public class TouchPhoneTest {

    @Test
    public void test() {
        // 获取 手机 = 样式  + 品牌
        Phone mi = new TouchPhone(new XiaoMi());
        mi.open();
        mi.call();
        mi.close();

        // 获取 手机 = 样式  + 品牌
        Phone vo = new TouchPhone(new Vivo());
        vo.open();
        vo.call();
        vo.close();
    }
}