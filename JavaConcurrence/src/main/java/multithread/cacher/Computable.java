package multithread.cacher;

/**
 * 业务: 计算接口, 用来定义业务操作并返回值, 放入到缓存中
 * 分别有两个实现类,分别实现不同功能, 作为包装
 *
 * @author Jion
 * @see UserIdComputeFunction 计算具体值
 * @see CustomizedCache 将计算值放入缓存中
 */
public interface Computable<A, V> {

    /**
     * 业务方法, 标识具体的计算, 交给子类去实现
     *
     * @param arg 计算参数
     * @return 具体的业务值, 回来返回到缓存中
     * @throws Exception 计算过程中允许抛出异常
     */
    V compute(A arg) throws Exception;
}
