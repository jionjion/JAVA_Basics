---
title: JAVA中XML文件的写操作
tags: JDK8, Eclipse, xml
---

[TOC]

---

## 简介
对Java中Xml文件或数据进行读操作.

## 包结构
- `dom` 使用DOM方式生成
- `dom4j`使用DOM4J方式生成
- `jdom`使用JDOM方式生成
- `sax`使用SAX方式生成

## 背景知识
JDK为我们提供了基础的DOM,SAX方式的用来解析XML.
其中DOM方式是基于DOM文件树的方式进行解析,而SAX是基于事件驱动的方式进行解析.
- DOM解析将结果以树的形式保存在内存中,便于理解和修改,但是对内存消耗大,不适合解析过大的文件.
- SAX采用事件驱动的方式,对内存消耗少, 但是不便于对文档修改和多处访问,一般仅用于处理XML数据.

在DOM解析基础上,扩展出来JDOM和DOM4J方式,均是针对于JAVA语言的解析方式
- JDOM方式仅使用具体类和大量Collections类,扩展性较差.
- DOM4J方式扩展了XML解析, 使用接口和抽象类,易于使用

速度:
SAX>DOM4J>JDOM>DOM

## DOM方式生成XML
通过创建`Document`对象,为其赋值节点和属性,将其写入文件中,最终生成XML文件.
1.创建`Document`对象
2.创建节点,设置属性并装载进入根节点
3.创建子节点,并装载进入父节点中.
4.设置转换格式,输出为XML文件

``` java
public static void main(String[] args) throws Exception{
	//引入文件
	File xml = new File("src/xmlReadAndWriter/xmlWrite/Books.xml");

	//创建一个DocumentBuilderFactory对象
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

	//创建一个DocumentBuilder对象
	DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

	//生成XML文件,创建Document对象
	Document document = documentBuilder.newDocument();
	document.setXmlStandalone(true);	//设置standalone为yes,不显示
	document.setXmlVersion("1.0");		//设置版本
	//创建节点,并添加到文件中,第一个节点为根节点
	Element bookStrore = document.createElement("bookstore");
	document.appendChild(bookStrore);
	//创建子节点,设置属性,并添加到父节点中.
	Element book = document.createElement("book");
	book.setAttribute("id", "1");
	bookStrore.appendChild(book);
	//为子节点设置带文本的子节点
	Element name = document.createElement("name");
	name.setTextContent("冰与火之歌");
	book.appendChild(name);
	Element author = document.createElement("author");
	author.setTextContent("乔治马丁");
	book.appendChild(author);
	Element year = document.createElement("year");
	year.setTextContent("2014");
	book.appendChild(year);
	Element price = document.createElement("price");
	price.setTextContent("98$");
	book.appendChild(price);

	//创建转换工厂,设置格式,进行输出
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");	//字符编码
	transformer.setOutputProperty(OutputKeys.INDENT, "yes");		//是否换行
	transformer.transform(new DOMSource(document), new StreamResult(xml));
}
```


## SAX方式生成XML
与解析时相似,基于事件生成XML.
1. 通过传入文件对象,生成`TransformerHandler`对象
2. 创建`Transformer`对象,设置版本信息
3. 创建节点,属性对象,开启文档对象
4. 循环开启节点,设置属性,结束节点
5. 最终结束文档对象.

``` java
public static void main(String[] args) throws Exception{

	//引入文件
	File xml = new File("src/xmlReadAndWriter/xmlWriter/Books.xml");

	//创建SAXTransformerFactory
	SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
	//创建TransformerHandler
	TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();
	//创建Transformer
	Transformer transformer = transformerHandler.getTransformer();
	//设置xml文件的属性,注意位置,在创建时设置
	transformer.setOutputProperty(OutputKeys.VERSION, "1.0");		//设置版本号
	transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");	//设置编码
	transformer.setOutputProperty(OutputKeys.INDENT, "yes");	 	//设置换行
	//创建Result对象,使其与Handler关联
	Result result = new StreamResult(new FileOutputStream(xml));
	transformerHandler.setResult(result);
	transformerHandler.startDocument();		//打开文档,进行节点生成
	//创建属性
	AttributesImpl attributes =  new AttributesImpl();
	//创建开始节点
	transformerHandler.startElement("", "", "bookstore", attributes);
	//创建子节点
	//属性清除,子节点创建属性
	attributes.clear();
	attributes.addAttribute("", "", "id", "", "1");
	//创开始子节点
	transformerHandler.startElement("", "", "book", attributes);
	//清除属性,创建子节点文本子节点
	attributes.clear();
	//文本节点
	transformerHandler.startElement("", "", "name", attributes);
	String name = "冰与火之歌";
	transformerHandler.characters(name.toCharArray(), 0,name.toCharArray().length);
	transformerHandler.endElement("", "", "name");
	//文本节点
	transformerHandler.startElement("", "", "author", attributes);
	String author = "乔治马丁";
	transformerHandler.characters(author.toCharArray(), 0,author.toCharArray().length);
	transformerHandler.endElement("", "", "author");
	//文本节点
	transformerHandler.startElement("", "", "year", attributes);
	String year = "2014";
	transformerHandler.characters(year.toCharArray(), 0,year.toCharArray().length);
	transformerHandler.endElement("", "", "year");
	//文本节点
	transformerHandler.startElement("", "", "price", attributes);
	String price = "98$";
	transformerHandler.characters(price.toCharArray(), 0,price.toCharArray().length);
	transformerHandler.endElement("", "", "price");

	//创建结束子节点
	transformerHandler.endElement("", "", "book");
	//创建结束节点
	transformerHandler.endElement("", "", "bookstore");
	transformerHandler.endDocument(); 		//关闭文档
}
```


## JDOM方式生成RSS
JDOM方式不仅可以生成标准的XML文件,也可以生成RSS文件,进行互联网传播.

``` java
public static void main(String[] args) throws Exception{
	//创建输出文件对象
	File xml = new File("src/xmlReadAndWriter/xmlWriter/News.xml");
	//生成Document对象
	Document document = new Document();
	//生成根节点,并设置属性,放入文档中
	Element rootRss = new Element("rss");
	rootRss.setAttribute("version", "3.0");
	document.setRootElement(rootRss);
	//设置子节点,及内容
	Element channel = new Element("channel");	//子节点<channel>
	channel.setText("新闻频道");
	rootRss.addContent(channel);
	Element title = new Element("title");	//子节点<title>
	title.setText("肚子饿了!!...>o<...");
	rootRss.addContent(title);

	CDATA code = new CDATA("不需要转移的代码片段.<JavaScript:alert('123')>");	//子节点
	rootRss.addContent(code);


	//设置格式
	Format format = Format.getPrettyFormat();
	format.setEncoding("GBK");	 			//在格式输出时,设置GBK编码
	//输出
	XMLOutputter xmlOutputter = new XMLOutputter(format);
	xmlOutputter.output(document, new FileOutputStream(xml));
}
```


## DOM4J方式生成RSS
DOM4J方式生成RSS文件

``` java
public static void main(String[] args) throws Exception{
	//创建输出文件对象
	File xml = new File("src/xmlReadAndWriter/xmlWriter/News.xml");
	//创建Document对象
	Document document = DocumentHelper.createDocument();
	//创建根节点<rss>
	Element rootRss = document.addElement("rss");
	//描述根节点,增加属性
	rootRss.addAttribute("version", "3.0");
	//生成子节点,及内容
	Element channel = rootRss.addElement("channel");	//子节点<channel>
	channel.setText("新闻频道");
	Element title = rootRss.addElement("title");	//子节点<title>
	title.setText("肚子饿了!!...>o<...");
	//设置格式
	OutputFormat outputFormat = OutputFormat.createPrettyPrint();
	outputFormat.setEncoding("GBK");	 			//在格式输出时,设置GBK编码
	//生成xml文件
	XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xml),outputFormat );
	xmlWriter.setEscapeText(false);					//设置是否进行转移,将文本中的字符进行转移
	xmlWriter.write(document);
	xmlWriter.close();
}
```
