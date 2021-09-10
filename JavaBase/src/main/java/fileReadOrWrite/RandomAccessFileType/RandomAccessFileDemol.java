package fileReadOrWrite.RandomAccessFileType;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * 	支持对文件的访问,支持编写文件
 * 	支持随机访问文件,支持访问文件的位置
 * 	打开文件的方式:	只读或者读写
 * 	打开文件时,需要指明指针位置和打开模式
 * 	文件模型:一组特定的byte字节数组
 * 	写:一次只写一个字节,同时指针后移
 * 	读:一次只读一个字节
 * 	读写完成后一定要关闭*/
public class RandomAccessFileDemol {

	public static void main(String[] args) throws Exception{
		File file = new File("F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\RandomAccessFileType\\RA");
		//随机读写文件,打开模式为读写模式
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		//指针发位置
		long place = randomAccessFile.getFilePointer();
		System.out.println("当前指针的位置:"+place);
		
		//写入一个字节
		randomAccessFile.write('A');
		System.out.println("当前指针的位置:"+randomAccessFile.getFilePointer());
		
		//写入一4字节的文字
		int i = 0x7fffffff;
		randomAccessFile.write(i >>> 24);	//最高8位
		randomAccessFile.write(i >>> 16);
		randomAccessFile.write(i >>> 8);
		randomAccessFile.write(i >>> 0);
		System.out.println("当前指针的位置:"+randomAccessFile.getFilePointer());
		
		//写入一个中文
		String string = "谦";
		byte[] utf = string.getBytes("utf-8");
		randomAccessFile.write(utf);
		System.out.println("文件当前的长度:"+randomAccessFile.length());
		
		/*读取文件*/
		//将指针归零
		randomAccessFile.seek(0);
		//创建一个和文件长度相同的字节数组
		byte[] buff = new byte[(int) randomAccessFile.length()];
		//蒋文件读入到字节数组中
		randomAccessFile.read(buff);
		//将字节数组输出,调用Arrays工具类,完成字节数粗到字符串的输出
		System.out.println(Arrays.toString(buff));
		
		//关闭文件
		randomAccessFile.close();
	}
}
