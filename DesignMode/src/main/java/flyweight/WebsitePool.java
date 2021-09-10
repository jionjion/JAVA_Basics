package flyweight;

import java.util.HashMap;

/**
 *  网站工厂类,根据需求返回池中的对象
 * @author Jion
 */
public class WebsitePool {

    /** 集合对象 */
    private final HashMap<String, NewWebsite> pool = new HashMap<String, NewWebsite>(10);

    /** 获得对象,存在拿去,否则创建返回并存放 */
    public Website getWebsite(String type){
        // 不存在,放入
        if(!pool.containsKey(type)){
            pool.put(type, new NewWebsite(type));
        }
        return pool.get(type);
    }
}
