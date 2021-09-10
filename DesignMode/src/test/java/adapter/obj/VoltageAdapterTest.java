package adapter.obj;

import org.junit.Test;


/**
 * @author Jion
 */
public class VoltageAdapterTest {

    @Test
    public void test(){
        // 适配器使用
        Voltage5V voltage5V = new VoltageAdapter();
        int output5V = voltage5V.output5V();
        // 适配器结果
        System.out.println("电压:" + output5V);
    }
}