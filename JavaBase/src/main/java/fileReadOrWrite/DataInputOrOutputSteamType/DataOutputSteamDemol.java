package fileReadOrWrite.DataInputOrOutputSteamType;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**	通过字符输出流输出文件
 * 	对原文件字符流进行包装*/
public class DataOutputSteamDemol {

	public static void main(String[] args) throws Exception {
		
		String file = "F:\\JAVA_WorkSpace\\JavaBase\\src\\fileReadOrWrite\\DataInputOrOutputSteamType\\DA";
		DataOutputStream dataOutputStream = new DataOutputStream(
								new FileOutputStream(file));
		
		//写方法
		dataOutputStream.writeInt(10);
		dataOutputStream.writeDouble(24.5d);
		//UTF-8编码
		dataOutputStream.writeUTF("张谦");
		//UTF-16be编码
		dataOutputStream.writeChars("张谦");
		dataOutputStream.close();
	}
}
