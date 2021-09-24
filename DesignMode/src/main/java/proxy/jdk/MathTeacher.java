package proxy.jdk;

/**
 * 目标类,必须实现接口
 *
 * @author Jion
 */
public class MathTeacher implements Teacher {

    /**
     * 目标类,方法
     */
    @Override
    public void tell() {
        System.out.println("老师正在授课...");
    }
}
