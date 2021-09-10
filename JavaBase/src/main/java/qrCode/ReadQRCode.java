package qrCode;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/**
 * 	使用zxinng.jar完成二维码的读取*/
public class ReadQRCode{

	public static void main(String[] args) throws Exception{
		
		MultiFormatReader formatReader = new MultiFormatReader();									
		
		File png = new File("src/qrCode/生成的二维码.png");												//读取的文件
		
		BufferedImage image = ImageIO.read(png);													//将图片读入
		
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));	//传入图片
		
		Map<DecodeHintType, Object> params = new HashMap<DecodeHintType, Object>();
		params.put(DecodeHintType.CHARACTER_SET, "UTF-8");											//编码格式
		params.put(DecodeHintType.TRY_HARDER, true);												//优化精度
		params.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);										//复杂模式，开启PURE_BARCODE模式
		Result result = formatReader.decode(binaryBitmap, params);									
		
		System.out.println("解析结果:"+result.toString());												//解析
		System.out.println("格式:"+result.getBarcodeFormat());										//生成格式
		System.out.println("文本:"+result.getText());													//文本信息
		System.out.println("创建时间"+(new SimpleDateFormat("yyyy-MM-dd").format(new Date(result.getTimestamp()))));	//生成日期
	}
}
