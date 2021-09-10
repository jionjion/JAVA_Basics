package javaThread;
/**	征用数据的模拟使用*/
public class EnergyTransferTask implements Runnable {

	//共享的能源世界
	private EnergySystem energySystem;
	//能量转移的盒子的下标
	private int fromBox;
	//单次能量转移的最大单元
	private double maxAmount;
	//最大休眠时间
	private int delay = 10;
	
	public EnergyTransferTask(EnergySystem energySystem,int from,double max) {
		this.energySystem = energySystem;
		this.fromBox = from;
		this.maxAmount = max;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				//随机个盒子,转移能量
				int toBox = (int)(energySystem.getBoxAmount()*Math.random());
				//随机个准备转移的能量数值
				double amount = maxAmount*Math.random();
				energySystem.transfer(fromBox, toBox, amount);
				//系统,随机休眠,防止过热
				Thread.sleep((int)(delay*Math.random()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("能量转移过程出现意外");
		}
	}

}
