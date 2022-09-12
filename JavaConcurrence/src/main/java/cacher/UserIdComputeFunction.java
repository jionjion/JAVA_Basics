package cacher;

import java.util.Random;

/**
 * 业务: 具体的业务操作, 返回业务值, 放入缓存
 *
 * @author Jion
 */
public class UserIdComputeFunction implements Computable<String, Integer> {

    @Override
    public Integer compute(String arg) throws Exception {
        System.out.println("复杂计算..." + arg);
        Thread.sleep(5000);
        return new Random().nextInt();
    }
}
