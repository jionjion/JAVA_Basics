package fileReadOrWrite.encoedType;

/**编码格式.文本文件时字节文件*/
public class EncodeType {

	public static void main(String[] args) throws Exception {
		String string = "中文ABC";
		byte[] by = null;	
		//GBK编码中文占用2个字符,英文占用1个字符
		by = string.getBytes("gbk");	
		//UTF-8编码中文用2个字符,英文占用1个字符
		by = string.getBytes("utf-8");
		//java的双字节,中文和英文均占2个字符
		by = string.getBytes("utf-16be");	
		for (byte b : by) {
			//将其与1,去掉前位的零,并转为十六进制
			System.out.print(Integer.toHexString(b & 0xff)+"  ");
		}
	}
}
