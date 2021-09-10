package com.model.adapter;
/**客户端*/
public class ClientClass {

	/*需要一个目标类*/
	private TargetInterface target;
	
	/*通过构造方法传入需要的目标类*/
	public ClientClass(TargetInterface target) {
		this.target = target;
	}
	
	/**使用目标类的方法*/
	public void use() {
		target.targetWay();
	}
	
	
	/**	测试方法,对接口类进行测试*/
	public static void main(String[] arg0){
		
		//1.独有目标类
		AdapteeClass adaptee1 = new AdapteeClass();
		//2.对目标类进行转换
		TargetInterface target1 = new AdapteerClassByImplements(adaptee1);
		//3.将转换后的目标类传入
		ClientClass client1 = new ClientClass(target1);
		client1.use();
		
		//1.使用继承对目标类进行转换
		TargetInterface target2 = new AdapteerClassByExtends();
		//2.将转换后的目标类传入
		ClientClass client2 = new ClientClass(target2);
		client2.use();
	
	}
}
