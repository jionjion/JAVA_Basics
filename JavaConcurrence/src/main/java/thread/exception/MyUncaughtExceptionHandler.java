package thread.exception;

/**
 * 说明: 自定义实现全局异常处理
 *
 * @author Jion
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        // 处理异常业务..
        throwable.printStackTrace();
        System.out.println(thread.getName() + "异常发生了, " + throwable.getMessage());
    }
}
