package commons.io.monitorDemo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.io.monitor.FileEntry;

/**
 *	文档监视器
 *	监视文档的状态变化
 */
public class FileMonitorExample {

	public static void main(String[] args) throws Exception{
		
		//文档
		String fileStr = "F:\\JAVA_WorkSpace\\JavaBase\\src\\commons\\io\\files\\fileA.txt";
		//目录
		String direStr = "F:\\JAVA_WorkSpace\\JavaBase\\src\\commons\\io\\files\\";
		
		//文档对象
		File fileA = FileUtils.getFile(fileStr);
		//目录对象
		File dire = FileUtils.getFile(direStr);
		
		/*
		 * 	将文档对象包装为文档实体,进行监视
		 */
	    FileEntry entry = new FileEntry(fileA);
	    System.out.println("监视文档的位置:" + entry.getFile());
	    System.out.println("文档名字:" + entry.getName());
	    System.out.println("文档是否为目录:" + entry.isDirectory());
	    System.out.println("文档是否最近被检查过:" + entry.isExists());
	    
	    /*
	     * 	创建观察方法,对目录下的文件进行监视
	     */
	    //传入目录,创建文档监视器
	    FileAlterationObserver observer = new FileAlterationObserver(dire);
	    //绑定监听方法
	    observer.addListener(new FileAlterationListener() {
			
			@Override
			public void onStop(FileAlterationObserver observer) {
				System.out.println("监视停止了...");
			}
			
			@Override
			public void onStart(FileAlterationObserver observer) {
				System.out.println("监视开启了...");
			}
			
			@Override
			public void onFileDelete(File file) {
				System.out.println("有文档删除了!!");
			}
			
			@Override
			public void onFileCreate(File file) {
				System.out.println("有文件新建了!!");
			}
			
			@Override
			public void onFileChange(File file) {
				System.out.println("有文件改变了!!");
			}
			
			@Override
			public void onDirectoryDelete(File directory) {
				System.out.println("有目录删除了!!");
			}
			
			@Override
			public void onDirectoryCreate(File directory) {
				System.out.println("有目录创建了!!");
			}
			
			@Override
			public void onDirectoryChange(File directory) {
				System.out.println("有目录改变了!!");
			}
		});
	    
	    /*
	     * 	创建监察者,传入观察方法和间隔时间,对文件进行监视
	     */
	    FileAlterationMonitor monitor = new FileAlterationMonitor(5000, observer);
	    monitor.start();
	    
	    //休眠一分钟,主线程阻塞,这这期间对文档的各种操作会被记录
	    Thread.sleep(1000*60);
	    
	    monitor.stop();
	}
}
