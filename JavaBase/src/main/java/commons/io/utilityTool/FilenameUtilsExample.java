package commons.io.utilityTool;

import org.apache.commons.io.FilenameUtils;

/**
 *	commons-io中常用的工具包
 *	FilenameUtils:与文件名相关,便于操作
 */
public class FilenameUtilsExample {

	public static void main(String[] args) {
		
		//文件路径
		String filename = "F:\\JAVA_WorkSpace\\JavaBase\\src\\commons\\io\\files\\fileA.txt";
		
		System.out.println("文件的全路径:" + FilenameUtils.normalize(filename));
		System.out.println("文件路径:" + FilenameUtils.getFullPath(filename));
		System.out.println("文件名和类型:" + FilenameUtils.getName(filename));
		System.out.println("文件名:" + FilenameUtils.getBaseName(filename));
		System.out.println("文件类型" + FilenameUtils.getExtension(filename));
		System.out.println("在项目的位置:" + FilenameUtils.getPathNoEndSeparator(filename));
	}
}
