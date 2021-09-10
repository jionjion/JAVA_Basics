package proxy.statics;

/**
 *  代理类,通过静态代理,扩展方法
 * @author Jion
 */
public class ProxyTeacher implements Teacher{

    /** 静态代理对象 */
    private final Teacher teacher = new MathTeacher();

    /** 代理类,方法 */
    public void tell() {
        System.out.println("代理类执行...");
        teacher.tell();
    }
}
