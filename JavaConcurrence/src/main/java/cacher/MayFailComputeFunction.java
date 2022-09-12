package cacher;

import java.io.IOException;
import java.util.Random;

/**
 * 业务: 具体的业务操作, 可能会失败..返回业务值, 放入缓存
 *
 * @author Jion
 */
public class MayFailComputeFunction implements Computable<String, Integer> {

    @Override
    public Integer compute(String arg) throws Exception {
        // 模拟概率失败
        if(Math.random() > 0.5){
            throw new IOException("哦...出错了..");
        }

        System.out.println("复杂计算..." + arg);
        Thread.sleep(5000);
        return new Random().nextInt();
    }
}
