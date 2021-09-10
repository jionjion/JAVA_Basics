package javaThread;
/**	能源系统
 * 	模拟数据征用条件*/
public class EnergySystem {

	//数据征用对象,在构造方法中初始化
	private final double[] energyBoxes;
	//锁对象
	private final Object lock = new Object();
	
	//初始化方法,创建数据对象数组
	public EnergySystem (int n,double initEnergy) {
		energyBoxes = new double[n];
		for(int i=0 ; i<energyBoxes.length; i++){
			energyBoxes[i] = initEnergy;	//每一个数组中的成员大小均为初始传入的值
		}
	}
	
	//能量的转移过程
	public void transfer(int from, int to ,double amount) throws Exception{
	
		//实现线程锁,但是获取锁,会增加系统开销
		synchronized (lock) {
			
			//如果原有的值小于准备转移的值,等待,禁止进入业务
			while(energyBoxes[from] < amount){
				lock.wait();	//释放线程锁,该线程等待,踢出CUP,其他线程继续抢占分时CPU
			}
			System.out.println("当前线程名:"+Thread.currentThread().getName());
			energyBoxes[from] -= amount;
			//格式化输出,适合变量多的
			System.out.printf("从%d号盒子转移[%3.2f]单位能量到%d号盒子..%n",from,amount,to);
			energyBoxes[to] += amount;
			System.out.printf("能量总和为:%10.2f..%n",getTotalEnergies());
			System.out.println("----------------------------------");
			
			lock.notifyAll(); //唤醒其他等待线程,继续抢占CPU资源,执行业务(此时随机数符合要求)
		}
	}

	//统计数组中个所有成员变量的值的和
	public double getTotalEnergies() {
		double sum = 0;
		for (double d : energyBoxes) {
			sum += d;
		}
		return sum;
	}
	
	//返回数组的长度
	public int getBoxAmount() {
		return energyBoxes.length;
	}
}
