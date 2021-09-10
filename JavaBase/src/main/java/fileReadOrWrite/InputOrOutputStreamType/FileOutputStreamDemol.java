package fileReadOrWrite.InputOrOutputStreamType;

import java.io.FileOutputStream;

/**输出*/
public class FileOutputStreamDemol {

	public static void main(String[] args) throws Exception {
		//文件路径
		String filePath = "F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\InputOrOutputStreamType\\SB";
		//文件不存在,则直接创建;文件存在,则删除后创建..(true:或者追加内容到文件)
		FileOutputStream out = new FileOutputStream(filePath);
		
		//写入字符
		out.write('A');//写出了A的低八位
		
		//四次写入整型数字
		int a = 11;
		out.write(a>>>24);	//右移24位,将高八位写入
		out.write(a>>>16);
		out.write(a>>>8);
		out.write(a);
		
		//写入字节数组
		byte[] utf = new String("张谦").getBytes("UTF-8");
		out.write(utf);
		out.close();
	}
}
