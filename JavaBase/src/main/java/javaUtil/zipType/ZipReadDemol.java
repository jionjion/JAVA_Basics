package javaUtil.zipType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;

import org.junit.Test;

/**
 *	通过读取文件,实现zip压缩格式的读取,分发
 */
public class ZipReadDemol {

	/*** 	实现单个文件的解压缩	 */
	@Test
	public void UnZipOneFile() {
	    try {
	    	//获得文件路径
			String rootPath = System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar + "javaUtil" + File.separatorChar + "zipType" 
								+ File.separatorChar + "test" + File.separatorChar ;		//获得当前项目根路径
			String txtZip = rootPath + "测试文本.zip";		//压缩文件
			String txt =  rootPath + "测试文本.txt";		//解压缩后文件
			//解压文件
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream (txt)));
			//文本->字节流->GZIP流->输入流->带缓冲的输入流
			BufferedReader reader = new BufferedReader(
			        new InputStreamReader(
			        		new GZIPInputStream(
			        				new FileInputStream(txtZip))));
			
			//读取一行
			String line;
			while ((line = reader.readLine()) != null) {
			    System.out.println(line);			//打印控制台
			    writer.write(line);
			    writer.newLine();
			}
			writer.flush();
			//输入流关闭
			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
