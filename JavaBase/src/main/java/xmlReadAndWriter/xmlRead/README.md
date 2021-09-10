---
title: JAVA中XML文件的读操作
tags: JDK8, Eclipse, xml
---

[TOC]

---

## 简介
对Java中Xml文件或数据进行读操作.

## 包结构
- `dom` 使用DOM方式解析
- `dom4j`使用DOM4J方式解析
- `jdom`使用JDOM方式解析
- `sax`使用SAX方式解析

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

## DOM方式解析XML
通过读取文件创建DOM文档对象,将DOM树加载进入内存中,可以对任意节点进行访问.
解析过程:
1. 读取文件,创建`document`对象
2. 获得感兴趣的节点们.
3. 遍历节点,获取属性和属性值
4. 获取子节点,其中空白也将会被看做一个节点 

``` java
public static void main(String[] args) throws Exception{

	//引入文件
	File file = new File("src/xmlReadAndWriter/xmlRead/Books.xml");

	//创建一个DocumentBuilderFactory对象
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

	//创建一个DocumentBuilder对象
	DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

	//解析XML文件,创建Document对象
	Document document = documentBuilder.parse(file);

	//解析Document对象
	//获得book节点.使用Dom方式解析可以获取任何我们感兴趣的节点,不需要层级关系
	NodeList bookLists = document.getElementsByTagName("book");	//返回的为一个节点list

	//遍历节点集合
	for (int i = 0; i < bookLists.getLength(); i++) {
		//解析每个book节点
		Node bookNode = bookLists.item(i);
		//节点名字
		String bookNodeName = bookNode.getNodeName();
		//获取book节点属性Map
		NamedNodeMap bookAttributes = bookNode.getAttributes();
		//遍历属性
		for (int j = 0; j < bookAttributes.getLength(); j++) {
			//莫得book节点每个属性对象
			Node attribute = bookAttributes.item(j);		//遍历每个属性
			//获得book节点每个属性
			String attributeName = attribute.getNodeName();		//获得属性名
//				String attributeValue = attribute.getNodeValue();	//互动属性值
			String attributeValue = ((Element) bookNode).getAttribute("id");	//将book节点强制换换为Element接口,其getAttribute("属性名")方法获取属性名对应的属性值
			System.out.println("节点:"+bookNodeName +"	属性名:"+attributeName+"	属性值:"+attributeValue);
		}

		//获得book节点的子节点,在解析时,空白也为一个节点.
		NodeList bookChildNodes = bookNode.getChildNodes();
		for (int k = 0; k < bookChildNodes.getLength(); k++) {
				Node bookChildNode = bookChildNodes.item(k);
			if (bookChildNode.getNodeType() == Node.ELEMENT_NODE) {	//如果为元素类型,则遍历
				String bookChildNodeName = bookChildNode.getNodeName();	//获得节点的名字
				String bookChildNodeValue = bookChildNode.getFirstChild().getNodeValue();	//默认节点的文本信息属于子节点内的值	
//					String bookChildNodeValue = bookChildNode.getTextContent();		//获得节点内的文本信息,仅限于获得纯文本的节点内容
				System.out.println("子节点:"+ bookChildNodeName+"	节点值:"+bookChildNodeValue);	//空白和换行符的为#text
			}

		}
	}
}
```

## SAX方式解析XML
SAX方式通过解析时加载文件和解析函数,完成基于事件的XML文档解析.
SaxHandler的编写需要继承`DefaultHandler.class`类,重写其中的解析方法,编写解析逻辑.

| 方法                                                                            | 说明             |
| ------------------------------------------------------------------------------- | ---------------- |
| public void startDocument()                                                     | 开始解析XML      |
| startElement(String uri, String localName, String qName, Attributes attributes) | 开始解析节点     |
| characters(char[] ch, int start, int length)                                    | 解析节点内字符串 |
| endElement(String uri, String localName, String qName)                          | 结束解析节点     |
| endDocument()                                                                   | 结束解析XML      |

``` java
public class SaxHandler extends DefaultHandler{
	/**开始解析xml*/
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("--------XML文件开始解析-------");
	}
	/**开始解析节点方法*/
	@Override			//qName:节点名	attributes:属性
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("-----节点:"+qName+"解析开始-----");
		//只有book标签有属性值.需要解析属性
		if (qName.equals("book")) {
			//遍历获取属性信息
			for (int i = 0; i < attributes.getLength(); i++) {
				String attributeName = attributes.getQName(i);		//遍历获取属性名
				String attributeValue = attributes.getValue(i);		//遍历获取属性值
//				String attributeValue = attributes.getValue("id");		//知道属性名,直接获取属性值
				System.out.println("节点:"+qName+"	属性名:"+attributeName+"	属性值:"+attributeValue);
			}
		}
		//解析只有只有文本的节点,即不是bookstore和book的节点
		if ( !qName.equals("bookstore") && !qName.equals("book") ) {
			String childNodeName = qName;
			System.out.print("节点:"+childNodeName);
		}
	}
	/**解析节点内的文本信息*/
	@Override			//ch:节点中的文本信息		start:开始的位置	length:文本的长度
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String childNodeValue = new String(ch, start, length);
		//SAX解析会将空格和换行解析为xml元素
		if (!"".equals(childNodeValue.trim())) {
			System.out.println("	节点值:"+childNodeValue);
		}
	}
	/**结束解析节点方法*/
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		//是否针对book节点结束
		System.out.println("-----节点:"+qName+"解析结束-----");	//每个节点结束后都触发
	}
	/**结束解析xml*/
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("--------XML文件结束解析-------");
	}
}
```

通过传入继承`DefaultHandler`类的实现类和需要解析的文档对象,完成XML的解析.

``` java
public static void main(String[] args) throws Exception {

	//引入文件
	File xml = new File("src/xmlReadAndWriter/xmlRead/Books.xml");
	//获取SAXParserFactory实例
	SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	//获取newSAXParser实例
	SAXParser saxParser = saxParserFactory.newSAXParser();
	//开始解析
	saxParser.parse(xml, new SaxHandler());
}
```


## JDOM方式解析XML
与DOM解析方式相似,不过不会将空字符串解析为子节点.
1. 加载文件,生成DOM对象
2. 获得根节点
3. 获得节点属性和属性值
4. 读取和遍历子节点.

``` java
public static void main(String[] args) throws Exception{
	//引入文件
	File xml = new File("src/xmlReadAndWriter/xmlRead/Books.xml");

	//创建SAXBuilder
	SAXBuilder saxBuilder = new SAXBuilder();
	//传入文件,创建Document对象
	Document document = saxBuilder.build(xml);
	//解析,生成根节点
	Element rootElement = document.getRootElement();
	//获得根节点下的子节点
	List<Element> childrenElements = rootElement.getChildren();
	//变量子节点
	for (Element children : childrenElements) {
		//节点名
		String childrenName = children.getName();
		//获得节点的属性
		List<Attribute> childrenAttributes = children.getAttributes();
		//变量属性集合
		for (Attribute childrenAttribute : childrenAttributes) {
			String childrenAttributeName  = childrenAttribute.getName(); //获得属性名
			String childrenAttributeValue  = childrenAttribute.getValue(); //获得属性值
			System.out.println("节点名:"+childrenName+"	属性:"+childrenAttributeName+"	属性值:"+childrenAttributeValue);
		}

		//获得子节点的子节
		List<Element> grandsonElements = children.getChildren();
		//遍历孙子节点
		for (Element grandsonElement : grandsonElements) {
			String grandsonElementName = grandsonElement.getName();
			String grandsonElementvalue = grandsonElement.getValue();
			System.out.println("孙子节点名: "+grandsonElementName+"	节点值: "+grandsonElementvalue);
		}
	}
}
```


## DOM4J方式解析XML
解析方式最为简单灵活
1. 读取XML文件
2. 获取根节点
3. 迭代子节点
4. 迭代获取节点属性

``` java
public static void main(String[] args) throws Exception{

	//引入文件
	File xml = new File("src/xmlReadAndWriter/xmlRead/Books.xml");
	//创建SAXReader对象
	SAXReader saxReader = new SAXReader();
	//加载XML,生成Document对象
	Document document = saxReader.read(xml);
	//获得根节点
	Element rootElement = document.getRootElement();
	//获得根节点下的子节点
	Iterator<Element> childrenIterator = rootElement.elementIterator();
	//遍历迭代器
	while (childrenIterator.hasNext()) {
		//获得book的节点
		Element childrenElement = (Element) childrenIterator.next();
		//获得book节点的节点名
		String childrenElementName = childrenElement.getName();
		//获得属性集合
		List<Attribute> childrenAttributes = childrenElement.attributes();
		//遍历属性集合
		for (Attribute childrenAttribute : childrenAttributes) {
			String childrenAttributeName = childrenAttribute.getName();
			String childrenAttributeValue = childrenAttribute.getValue();
			System.out.println("节点:"+childrenElementName+"	属性名:"+childrenAttributeName+"	属性值:"+childrenAttributeValue);
		}
		//解析book节点的子节点
		Iterator<Element> grandsonIterator = childrenElement.elementIterator();
		while (grandsonIterator.hasNext()) {
			Element grandsonElement = (Element) grandsonIterator.next();
			String grandsonName = grandsonElement.getName();
			String grandsonValue = grandsonElement.getText();
			System.out.println("节点名:"+grandsonName+"	节点值:"+grandsonValue);
		}
	}
}
```
