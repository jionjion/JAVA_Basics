package concurrency.filter;

/** 希望保存在线程中的信息 */
public class ThreadInfo{
	//创建每个线程独有的变量信息
	private final static ThreadLocal<String> LOCAL = new ThreadLocal<>();
	
	//赋值
	public static void setInfo(String info) {
		LOCAL.set(info);
	}
	
	//获得
	public static String getInfo() {
		return LOCAL.get();
	}
	
	//删除,如果不删除,持续停留在项目中
	public static void remove() {
		LOCAL.remove();
	}
}