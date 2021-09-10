package fileReadOrWrite.fileType;

import java.io.File;

/***
 * 	File类用于文件或者目录
 * 	只是表示文件的信息(名称,大小),不能进行文件的访问
 * 	*/
public class FileModel {

	public static void main(String[] args) throws Exception{
		//自动根据操作系统.实现文件分隔
		String filePath = "F:"+File.separatorChar+"JAVA_WorkSpace"+File.separatorChar
								+"JavaBase"+File.separatorChar+"src"+File.separatorChar
								+"fileReadOrWrite"+File.separatorChar+"fileType"+File.separatorChar+"FA";
		//传入文件名进行构建
		File file = new File(filePath);
		//传入目录和文件名进行构建
		file = new File("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\fileType","FA");
		//判断文件是否存在
		if (file.exists()) {
			System.out.println("文件存在");
			//判断文件是否为目录
			if (file.isDirectory()) {
				System.out.println("文件是目录");
			}
			//判断是否是文件
			if (file.isFile()) {
				System.out.println("文件是文件");
			}
			//删除文件
			file.delete();
			System.out.println("删除文件");
		//判断文件不存在,则创建
		}else {
			//直接打印,则打印文件的位置
			System.out.println("创建新文件:"+file.toString());
			//打印文件的位置
			System.out.println("创建新文件:"+file.getAbsolutePath());
			//打印文件的名字
			System.out.println("文件的名字:"+file.getName());
			//文件的父目录
			System.out.println("文件的父目录:"+file.getParent());
			//创建文件
			file.createNewFile();
			
		}
	}
}
