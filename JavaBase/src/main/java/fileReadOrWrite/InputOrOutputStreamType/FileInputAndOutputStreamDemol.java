package fileReadOrWrite.InputOrOutputStreamType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**文件的拷贝工作*/
public class FileInputAndOutputStreamDemol {

	/**文件的拷贝工作*/
	public static void copyFile(File srcFile,File destFile) throws Exception{
		if (!srcFile.exists() || !srcFile.isFile()) {
			throw new IOException("文件不存在或不是文件");
		}
		
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buff = new byte[2*1024];		//批量读取
		int p ;		//文件的截止位置
		
		//文件批量读取,读取0到字节数组长度的字符,并返回读到的末尾位置,如果不是-1,则继续下去
		while( (p=in.read(buff, 0, buff.length)) != -1){
			out.write(buff,0,p);
			out.flush();
		}
		out.close();
		in.close();
	}
	
	
	/**测试 */
	public static void main(String[] args) throws Exception {
		File srcFile = new File("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\InputOrOutputStreamType\\SA");
		File destFile = new File("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\InputOrOutputStreamType\\SB");
		copyFile(srcFile, destFile);
	}
	
}
