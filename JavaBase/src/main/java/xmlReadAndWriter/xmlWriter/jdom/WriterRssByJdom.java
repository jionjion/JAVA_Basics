package xmlReadAndWriter.xmlWriter.jdom;

import java.io.File;
import java.io.FileOutputStream;

import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**	使用JDOM形式生成RSS文件*/
public class WriterRssByJdom {

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
}
