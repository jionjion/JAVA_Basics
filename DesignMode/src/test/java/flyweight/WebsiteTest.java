package flyweight;

import org.junit.Test;

/**
 *  测试
 * @author Jion
 */
public class WebsiteTest {

    @Test
    public void test(){
        WebsitePool pool = new WebsitePool();

        // 获得,并存放一个
        User jion = new User("Jion");
        BaseWebsite newWebsite = pool.getWebsite("NEW");
        newWebsite.use(jion);
        // 再次获得一个
        User arise = new User("Arise");
        BaseWebsite musicWebsite = pool.getWebsite("Music");
        musicWebsite.use(arise);
        // 重试从缓存中,相同对象,不同调用
        User bom = new User("Bom");
        BaseWebsite cacheWebsite = pool.getWebsite("NEW");
        cacheWebsite.use(bom);
    }
}