package multithread.cacher;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 业务: 自定义缓存..
 * 场景: 通过实现 Computable 接口, 将计算中的数据类型进行缓存
 *
 * @author Jion
 */
public class CustomizedCache<A, V> implements Computable<A, V> {
    /**
     * 优化: 使用 final 关键字, 去修饰并且标识当前对象引用不可变
     * 优化: 使用 ConcurrentHashMap 并发工具类, 避免线程 put/get 读取问题
     * 优化: 使用 Future 包装返回值, 将当前任务放入到 Callable 队列中..
     */
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();


    /**
     * 优化: 装饰器模式, 要装饰的基类
     */
    private final Computable<A, V> computer;

    /**
     * 构造函数中传入要装饰的基类
     */
    public CustomizedCache(Computable<A, V> computer) {
        this.computer = computer;
    }


    /**
     * 在当前装饰器中计算并放入到缓存中
     *
     * @param arg 计算参数
     * @return 返回值..
     * @throws Exception 发生了异常
     */
    @Override
    public V compute(A arg) throws Exception {
        // 自带重试, 如果程序正常执行, return 返回结果; 如果发生异常, 抛出或者继续循环..
        while (true) {
            System.out.println("进入到缓存机制");
            Future<V> future = cache.get(arg);
            // 不存在, 可能未计算, 或者多个线程都在计算..
            if (future == null) {
                // 构建计算任务
                Callable<V> callable = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return computer.compute(arg);
                    }
                };
                // 创建任务
                FutureTask<V> futureTask = new FutureTask<>(callable);
                // 修改引用, 避免为空时, future.get() 抛出异常
                // future = futureTask;
                // 放入缓存, 如果为当前缓存中不存在的话,放入; 存在,返回缓存值
                future = cache.putIfAbsent(arg, futureTask);
                // 缓存中不存在, 再执行计算
                if (future == null) {
                    future = futureTask;
                    // 执行计算计算
                    System.out.println("从 FutureTask 调用的计算方法");
                    futureTask.run();
                }

            }

            // 异常处理
            try {
                return future.get(10, TimeUnit.SECONDS);
            } catch (CancellationException e) {
                // 取消时异常
                System.out.println("被取消的");
                // 删除旧错误的缓存
                cache.remove(arg);
                throw e;
            } catch (InterruptedException e) {
                // 打断程序异常
                cache.remove(arg);
                throw e;
            } catch (ExecutionException e) {
                // 执行失败异常
                System.out.println("计算失败...重试");
                cache.remove(arg);
            }
        }
    }

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

    /**
     * 带有超时功能的缓存
     */
    public V compute(A arg, Long expecteSeconds) throws Exception {
        if (expecteSeconds > 0) {
            // 延时. 清除
            scheduler.schedule(new Runnable() {
                @Override
                public void run() {
                    expire(arg);
                }
            }, expecteSeconds, TimeUnit.SECONDS);
        }
        // 正常的储存
        return compute(arg);
    }

    /**
     * 清除缓存
     */
    public synchronized void expire(A key) {
        if (cache.containsKey(key)) {
            // 缓存中, 任务正在执行时的情况
            Future<V> future = cache.get(key);
            if (!future.isDone()) {
                System.out.println("Future 任务取消");
                future.cancel(true);
            }

            // 清除缓存
            System.out.println("过期清除");
            cache.remove(key);
        }
    }

    /**
     *  缓存随机过期
     */
    public V computeRandomExpire(A arg) throws Exception{
        // 随机过期10秒内, 避免缓存雪崩
        long random = (long) (Math.random() * 10);
        return compute(arg, random);
    }

    public static void main(String[] args) throws Exception {
        // 装饰器密匙, 在构造函数中传入计算的具体类.
        CustomizedCache<String, Integer> cache = new CustomizedCache<>(new MayFailComputeFunction());

        new Thread(() -> {
            try {
                Integer computeA = cache.compute("11", 10L);
                System.out.println("并发失算第一次:" + computeA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Integer computeA = cache.compute("22");
                System.out.println("并发失算第二次:" + computeA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Integer computeA = cache.compute("11");
                System.out.println("并发失算第三次:" + computeA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
