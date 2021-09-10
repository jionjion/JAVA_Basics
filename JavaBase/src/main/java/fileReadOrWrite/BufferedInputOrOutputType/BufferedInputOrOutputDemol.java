package fileReadOrWrite.BufferedInputOrOutputType;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputOrOutputDemol {

	/**文件的拷贝*/
	public static void copyFile(File srcFile,File destFile) throws Exception{
		if (!srcFile.exists() || !srcFile.isFile()) {
			throw new IOException("文件不存在或不是文件");
		}
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
										new FileInputStream(srcFile));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
										new FileOutputStream(destFile));
		int p ;		//文件的读取位置
		//文件批量读取,读取0到字节数组长度的字符,并返回读到的末尾位置,如果不是-1,则继续下去
		while( (p=bufferedInputStream.read()) != -1){
			bufferedOutputStream.write(p);
		}
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
		bufferedInputStream.close();
	}
	
	public static void main(String[] args) throws Exception {
		File srcFile = new File("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\BufferedInputOrOutputType\\BA");
		File destFile = new File("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\BufferedInputOrOutputType\\BB");
		copyFile(srcFile, destFile);
	}
}
