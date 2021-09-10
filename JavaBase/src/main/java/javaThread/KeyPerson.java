package javaThread;
/**关键人物,继承Thread实现多多线程*/
public class KeyPerson extends Thread {

	@Override
	public void run() {
		System.out.println("关键人物:"+getName()+"进入了");
		for (int i = 1; i < 10; i++) {
			System.out.println(getName()+"进攻了["+i+"]次");
		}
		System.out.println("关键人物:"+getName()+"离开了");
	}
}
