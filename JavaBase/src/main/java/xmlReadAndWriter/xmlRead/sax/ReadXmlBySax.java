package xmlReadAndWriter.xmlRead.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**	使用Sax方式解析XML文件
 * 	需要写一个Handler类,由上往下,完成各种解析.
 * */
public class ReadXmlBySax {

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
}
