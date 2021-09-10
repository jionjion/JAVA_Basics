package adapter.inter;

import org.junit.Test;

/**
 * 通过重写默认方法
 *
 * @author Jion
 */
public class AbstractVoltageTest {

    @Test
    public void output220V() {
        AbstractVoltage voltage = new AbstractVoltage() {
            @Override
            public int output220V() {
                System.out.println("重写方法...");
                return 220;
            }
        };

        voltage.output220V();
    }
}