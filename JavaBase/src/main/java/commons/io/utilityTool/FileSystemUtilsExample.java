package commons.io.utilityTool;

import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;

/**
 *	FileSystemUtils：返回指定储存介质的可用空间
 */
public class FileSystemUtilsExample {

	public static void main(String[] args) throws IOException {
		//查看当前储存分区剩余可用空间 ,单位KB
		System.out.println(FileSystemUtils.freeSpaceKb());
		//查看指定储存分区剩余可用空间 ,单位KB
		System.out.println(FileSystemUtils.freeSpaceKb("C:"));
	}
}
