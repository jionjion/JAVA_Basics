package fileReadOrWrite.DataInputOrOutputSteamType;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputSteamDemol {

	public static void main(String[] args) throws Exception{
		//文件路径
		String filePath = "F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\InputOrOutputStreamType\\SB";
		DataInputStream dataInputStream = new DataInputStream(
						new FileInputStream(filePath));
		//读取整形
		System.out.println(dataInputStream.readInt());
		//读取双精度浮点型
		System.out.println(dataInputStream.readDouble());
		//读取UTF-8编码
		System.out.println(dataInputStream.readUTF());
		//读取UTF-16be编码
		System.out.println(dataInputStream.readChar());
		dataInputStream.close();
		
	}
}
