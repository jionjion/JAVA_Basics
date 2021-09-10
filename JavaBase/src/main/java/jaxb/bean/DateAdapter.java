package jaxb.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *	适配器,将日期根据指定格式转出
 *	
 */
public class DateAdapter extends XmlAdapter<String, Calendar> {

	@Override
	public Calendar unmarshal(String str) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(str);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	@Override
	public String marshal(Calendar calendar) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");		
		Date date = calendar.getTime();
		return format.format(date);
	}
}
