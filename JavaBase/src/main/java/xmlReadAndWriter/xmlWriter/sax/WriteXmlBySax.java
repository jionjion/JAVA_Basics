package xmlReadAndWriter.xmlWriter.sax;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.transform.*;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.helpers.AttributesImpl;

/**	使用SAX方式,生成XML*/
public class WriteXmlBySax {

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
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");		//设置换行
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
}
