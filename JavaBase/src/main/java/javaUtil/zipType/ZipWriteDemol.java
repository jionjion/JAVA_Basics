package javaUtil.zipType;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.zip.GZIPOutputStream;

import org.junit.Test;

/**
 *	通过写入文件,实现zip压缩格式的创建,压缩
 */
public class ZipWriteDemol {

	/*** 	实现单个文件的压缩,压缩后文件后缀名消失	 */
	@Test
	public void ZipOneFile() {
		try {
			//获得文件路径
			String rootPath = System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar + "javaUtil" + File.separatorChar + "zipType" 
								+ File.separatorChar + "test" + File.separatorChar ;		//获得当前项目根路径
			String txt =  rootPath + "测试文本.txt";
			String txtZip = rootPath + "测试文本.zip";
			//创建输入流和压缩输出流
			BufferedInputStream  in  = 	new BufferedInputStream(						//带缓冲的字符输入节流 
											new FileInputStream(txt) );					//文件读取
			BufferedOutputStream out = 	new BufferedOutputStream(						//带缓冲的字符输出流
											new GZIPOutputStream(						//包装字符输出流
												new FileOutputStream(txtZip)));			//原本的文件输出流
			//进行文件的读取
			byte[] buff = new byte[1024];
			int point = 0;
			while( (point = in.read(buff,0,buff.length)) != -1) {
				out.write(buff,0,point);
			}
			in.close();
			out.close();
			out.flush();			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
