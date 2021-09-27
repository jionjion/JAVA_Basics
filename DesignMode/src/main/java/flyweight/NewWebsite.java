package flyweight;

/**
 * 具体子类,新闻类型
 *
 * @author Jion
 */
public class NewWebsite extends BaseWebsite {

    /**
     * 具体的新闻类别,相似的部分
     */
    private final String type;


    public NewWebsite(String type) {
        this.type = type;
    }

    @Override
    protected void use(User user) {
        System.out.println("当前对象使用者: " + user.getUsername());
        System.out.println("新闻网站的类型为: " + type + " ,对象哈希为: " + this.hashCode());
    }
}
