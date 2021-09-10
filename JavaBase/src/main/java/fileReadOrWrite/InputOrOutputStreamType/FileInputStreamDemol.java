package fileReadOrWrite.InputOrOutputStreamType;

import java.io.FileInputStream;

public class FileInputStreamDemol {
	/**通过单个字节读取文件,并打印*/
	public void readAndPrintByByte(String fileName) throws Exception{
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i=1;
		while( (b=in.read()) != -1){
			if ((b&0xff) <= 0xf) {
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+"  ");
			if (i%10 ==0) {
				System.out.println("");
			}
			i++;
		}
		in.close();
	}
	
	/**通过字节数组读取文件,并打印*/
	public void readAndPrintByByteArray(String fileName) throws Exception{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buff = new byte[2*1024];
		int j=1;
		//批量读取字节,放入到字节数组中,从第0个位置开始,最多放buff.length个
		while( (in.read(buff,0,buff.length)) != -1){
			for (int i = 0; i < buff.length; i++) {
				if ((buff[i]&0xff) <= 0xf) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(i)+"  ");
				if (j%10 ==0) {
					System.out.println("");
				}
				j++;
			}
		}
		in.close();
	}
	
	public static void main(String[] args) throws Exception{
		String fileName = "F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\InputOrOutputStreamType\\SA";
		//通过字节读取文件
		new FileInputStreamDemol().readAndPrintByByte(fileName);
		//通过字节数组读取文件
		new FileInputStreamDemol().readAndPrintByByte(fileName);
	}
}
