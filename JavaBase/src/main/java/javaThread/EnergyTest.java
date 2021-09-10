package javaThread;

public class EnergyTest {

	//盒子个数
	private static final int BOX_AMOUT = 100;
	//每个盒子的初始能量
	private static final double INIT_ENERGY = 1000;
	
	public static void main(String[] args) {
		EnergySystem energySystem = new EnergySystem(BOX_AMOUT, INIT_ENERGY);
		//对每个盒子进行一次能量转移
		for (int i=0 ; i<BOX_AMOUT ; i++) {
			//传入从出初始化后的能量世界,最大的盒子个数,每个盒子的最大能量数
			EnergyTransferTask task = new EnergyTransferTask(energySystem, i, INIT_ENERGY);
			//开启多线程进行执行
			Thread thread = new Thread(task, "能量系统转移任务_"+i);
			thread.start();
		}
		
		//计算最后总能量
		System.out.println("总能量:"+energySystem.getTotalEnergies());
	}
}
