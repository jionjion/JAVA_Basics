package adapter.obj;

/**
 *  适配器
 * @author Jion
 */
public class VoltageAdapter implements Voltage5V {

    /** 持有被适配的类，set或构造器传入 */
    private Voltage220V voltage220V = new Voltage220V();

    /** 适配器方法 */
    @Override
    public int output5V() {
        // 创建父类,并调用
        int output220V = voltage220V.output220V();
        // 适配处理,输出5V
        System.out.println("输出5V电压");
        return output220V / 44;
    }
}
