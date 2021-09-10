---
title: JAVA中二维码操作
tags: JDK8, Eclipse, QRCode
---

[TOC]

---

## 简介
使用`QRCode`包完成二维码的生成和读取


## 文件

* `CreateQRCode`  生成二维码图片
* `ReadQRCode`  读取二维码图片

## 文件描述


### `CreateQRCode`类
生成二维码的类,设置初始参数,完成二维码的自动生成.


常用的参数有:

| 参数名                           | 参数值                   | 说明                                                                                                            |
| -------------------------------- | ------------------------ | --------------------------------------------------------------------------------------------------------------- |
| EncodeHintType.ERROR_CORRECTION  | ErrorCorrectionLevel枚举 | 纠错等级 L<M<Q<H                                                                                                |
| EncodeHintType.CHARACTER_SET     | GBK,UTF-8                | 字符编码                                                                                                        |
| EncodeHintType.MARGIN            | 5<基本类型>              | 边距,默认单位像素                                                                                               |
| EncodeHintType.DATA_MATRIX_SHAPE | SymbolShapeHint枚举      | 二维码形状,一般选择FORCE_NONE,正方形                                                                            |
| EncodeHintType.PDF417_COMPACT    | true<布尔值>             | 是否紧凑布局                                                                                                    |
| EncodeHintType.PDF417_COMPACTION | Compaction枚举类         | 一般TEXT方法,文本压缩                                                                                           |
| EncodeHintType.PDF417_DIMENSIONS | Dimensions对象           | new Dimensions(25, 30, 25, 30),设置二维码行列数值                                                               |
| EncodeHintType.AZTEC_LAYERS      | 0<基本类型>              | 指定阿兹特克代码所需的层数。负数[- 1,- 4]指定紧凑的;0表示使用最小层数（默认值）;正数[1, 32]非紧凑阿兹特克代码。 |
| EncodeHintType.QR_VERSION        | 10<基本类型>             |                                                                                                                 |


梳理流程

 - 设置宽高,初始参数
 - 传入内容,二维码格式,宽高,初始参数生成二维码对象
 - 将其写入文件或者输出流中

``` java
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
```


### `ReadQRCode`类

读取二维码的类,从图片或者图片输入流中获取内容.

常用参数有:

| 参数名                       | 参数值        | 说明     |
| ---------------------------- | ------------- | -------- |
| DecodeHintType.CHARACTER_SET | GBK,UTF-8     | 编码格式 |
| DecodeHintType.TRY_HARDER    | true<布尔值>  | 复杂程度 |
| DecodeHintType.PURE_BARCODE  | TRUE<Boolean> | 复杂模式 |


梳理流程

 - 从文件或者输入流中获取图片信息
 - 创建图片对象
 - 设置初始参数
 - 解析二维码内信息



``` java
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
```
