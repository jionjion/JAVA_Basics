package qrCode;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**使用zxinng.jar完成二维码的生成*/
public class CreateQRCode {

	public static void main(String[] args) throws Exception{
		
		//1.定义参数
		int width = 500;
		int height = 500;
		String imgType = "png";
		String contents = "https://github.com/";	
		Map<EncodeHintType, Object> params = new HashMap<EncodeHintType, Object>();
		params.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.Q);							//纠错等级  L<M<Q<H
		params.put(EncodeHintType.CHARACTER_SET, "UTF-8");											//编码格式
		params.put(EncodeHintType.MARGIN, "8");														//边距,默认为5px
		params.put(EncodeHintType.DATA_MATRIX_SHAPE,SymbolShapeHint.FORCE_NONE);					//枚举DataMatrix符号形状构成正方形二维码
		params.put(EncodeHintType.PDF417_COMPACT,true);												//是否紧凑布局
		params.put(EncodeHintType.PDF417_COMPACTION,Compaction.TEXT);								//压缩方式
		params.put(EncodeHintType.PDF417_DIMENSIONS,new Dimensions(25, 30, 25, 30));				//行列
		params.put(EncodeHintType.AZTEC_LAYERS, -1)	;//*指定阿兹特克代码所需的层数。负数（- 1，- 2，- 3，- 4）指定紧凑的;0表示使用最小层数（默认值）;正数（1, 2，…）32）指定一个正常（非紧凑）阿兹特克代码。
		params.put(EncodeHintType.QR_VERSION, 10);													//版本 1~40,越大二维码越密集
			
		//生成二维码,传入内容,编码方式,二维码生成的宽,二维码生成的高,二维码参数定义
	    BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, params);
	    //将二维码写入流中
	    //MatrixToImageWriter.writeToStream(bitMatrix, imgType, new FileOutputStream("可以写入流中,完成网络传输..."));
	    //将二维码传入路径文件中.
	    Path png = new File("src/qrCode/生成的二维码.png").toPath();
	    MatrixToImageWriter.writeToPath(bitMatrix, imgType, png);
	}
}
