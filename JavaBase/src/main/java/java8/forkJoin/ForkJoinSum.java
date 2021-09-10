package java8.forkJoin;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 *  @author Jion
 *      通过 Fork-Join方式进行求和运算
 *      RecursiveAction:    无返回值
 *      RecursiveTask<T>:   有返回值
 *
 *          示例:
 *      计算一个范围内的数字和,当范围过大时,拆分求和.
 */
public class ForkJoinSum extends RecursiveTask<Long> {

    /** 最小任务区间 */
    private static final long THRESHOLD = 100;

    /** 计算开始 */
    private Long start;

    /** 计算结束 */
    private Long end;


    public ForkJoinSum(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    /** 计算方法 */
    @Override
    protected Long compute() {

        // 区间大小
        long length = end - start;

        // 区间符合要求,计算求和
        if(length <= THRESHOLD){
            long sum = 0;
            for(long i=start ; i<=end ; i++){
                sum += i;
            }
            return sum;
        // 区间过大,继续拆分1
        }else{
            long middle = ( start + end ) / 2;

            // 递归执行,拆分子任务,放入线程队列
            ForkJoinSum left = new ForkJoinSum(start, middle);
            left.fork();

            ForkJoinSum right = new ForkJoinSum(middle+1, end);
            right.fork();

            // 返回执行结果
            return left.join() + right.join();
        }
    }
}
