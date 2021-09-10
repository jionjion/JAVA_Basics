package bridge;

import org.junit.Test;

/**
 * 通过桥接模式,将样式与品牌相组合
 *
 * @author Jion
 */
public class FoldedPhoneTest {

    @Test
    public void test() {
        // 获取 手机 = 样式  + 品牌
        Phone mi = new FoldedPhone(new XiaoMi());
        mi.open();
        mi.call();
        mi.close();

        // 获取 手机 = 样式  + 品牌
        Phone vo = new FoldedPhone(new Vivo());
        vo.open();
        vo.call();
        vo.close();
    }
}