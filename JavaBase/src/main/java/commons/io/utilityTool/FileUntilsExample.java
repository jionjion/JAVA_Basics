package commons.io.utilityTool;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 *	FileUtils: 文件操作（移动，打开和读取文件，检查文件是否存在等）的方法
 */
public class FileUntilsExample {

	public static void main(String[] args) throws Exception {
		
		//文件路径
		String filename = "F:\\JAVA_WorkSpace\\JavaBase\\src\\commons\\io\\files\\fileA.txt";
		//文件夹路径
		String direname = "F:\\JAVA_WorkSpace\\JavaBase\\src\\commons\\io\\files\\";
		
		//文件对象
		File file = FileUtils.getFile(filename);
		//文件夹对象
		File dire = FileUtils.getFile(direname);
		
		
		/*
		 * 	文档内容迭代器
		 */
		LineIterator lineIterator = FileUtils.lineIterator(file);
		while (lineIterator.hasNext()) {
			String line = (String) lineIterator.next();
			System.out.println("读取信息>>>  " + line);
		}
		
		/*
		 *	判断文件夹中是否含有当前文件 	
		 */
		System.out.println("当前文件夹是否含有该文件:" + FileUtils.directoryContains(dire, file));
		
		/*
		 * 	获得当前的用户目录路径 	
		 */
		System.out.println(FileUtils.getUserDirectoryPath());
		
	}
}
