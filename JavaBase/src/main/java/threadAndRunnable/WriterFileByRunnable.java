package threadAndRunnable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/***
 *	对文件进行写操作, 
 */
public class WriterFileByRunnable implements Runnable {

	@Override
	public void run() {

		System.out.println("进入守护线程:"+Thread.currentThread().getName());
		try {
			writerToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("退出守护线程:"+Thread.currentThread().getName());
	}

	/**	向文件中写入文字*/
	private void writerToFile() throws Exception{
		File file = new File("F:\\JAVA_WorkSpace\\JavaBase\\src\\threadAndRunnable\\File.txt");
		OutputStream outputStream = new FileOutputStream(file, true);
		int count = 1;
		while (count<=1000) {
			outputStream.write(("\nword"+count).getBytes());
			count++;
			Thread.sleep(1000);
			System.out.println("守护线程向文件中写入中.....");
		}
		outputStream.close();
	}
	
	/**	在主方法中调用 */
	public static void main(String[] args) {
		
		System.out.println("主线程开始................");
		//创建线程类
		WriterFileByRunnable writer = new WriterFileByRunnable();
		Thread writerThread = new Thread(writer);
		writerThread.setDaemon(true);					//设置为守护线程
		writerThread.start(); 							//线程开始
		
		//通过键盘输入,阻塞当主线程
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
		System.out.println("主线程结束................");
	}

}
