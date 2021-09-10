package lomback;

import lombok.Synchronized;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jion
 *      \@Synchronized 注解
 *          与 synchronized 相似,修饰静态和实例方法.保持线程一致
 */
public class SynchronizedAnnotateExample {

    /** 定义锁 */
    private final Object readLock = new Object();

    @Synchronized
    public static void sayHello(String name) {
        System.out.println("Hello, " + name.toUpperCase());
    }

    @Synchronized
    public double getRandom() {
        return Math.floor(Math.random() * 1000);
    }

    @Synchronized("readLock")
    public void sayHi(String name) {
        System.out.println("Hi, " + name.toUpperCase());
    }

    @Test
    public void testSayHello(){
        sayHello("Jion");
    }

    @Test
    public void testGetRandom(){
        Assert.assertNotNull(getRandom());
    }

    @Test
    public void testSayHi(){
        sayHi("Jion");
    }
}

