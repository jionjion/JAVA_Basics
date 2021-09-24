package fileReadOrWrite.fileType;

import java.io.File;

/**对目录进行操作*/
public class FileQuery {

	/**对目录进行遍历*/
	public static void listDirectory(File dir) throws Exception {
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录"+dir+"不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir+"不是目录");
		}
		//获得该目录下的所有子文件的名字
		String[] fileNames = dir.list();
		for (String string : fileNames) {
			//输出路径+文件名
			System.out.println(dir.getAbsolutePath()+string);
		}
		//获得该目录下的所有子文件
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				listDirectory(file);
			}
		}
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		String directory = "F:\\JAVA_WorkSpace\\JavaBase";
		File dir = new File(directory);
		listDirectory(dir);
	}
}
