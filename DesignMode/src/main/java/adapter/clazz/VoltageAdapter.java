package adapter.clazz;

/**
 *  适配器
 * @author Jion
 */
public class VoltageAdapter extends Voltage220V implements Voltage5V {


    /** 适配器方法 */
    public int output5V() {
        // 获得父类方法,并调用
        int output220V = super.output220V();
        // 适配处理,输出5V
        System.out.println("输出5V电压");
        return output220V / 44;
    }
}
