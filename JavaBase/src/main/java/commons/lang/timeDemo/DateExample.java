package commons.lang.timeDemo;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 	日期类
 * @author JionJion
 */

public class DateExample {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		
		/*
		 * 	DateUtils 封装了对 Calendar 和 Date类的使用	
		 */
		
		//标准秒
		long second = DateUtils.MILLIS_PER_SECOND;		//1000
		
		// 生成Date对象
		Date date = DateUtils.parseDate("2018/01/01 00:00:00","yyyy/MM/dd HH:mm:ss");
		// 中国当地时间
			 date = DateUtils.parseDate("2018/01/01 00:00:00",Locale.CHINESE,"yyyy/MM/dd HH:mm:ss");
		
		 
		// 1毫秒后
		DateUtils.addMilliseconds(date, 1);
		
		// 1秒后
		DateUtils.addSeconds(date, 1);
		
		// 1分钟后
		DateUtils.addMinutes(date, 1);
		
		// 1小时后
		DateUtils.addHours(date, 1);
		
		// 1天后
		DateUtils.addDays(date, 1);
		
		// 1星期后
		DateUtils.addWeeks(date, 1);
		
		// 1个月前
		DateUtils.addMonths(date, -1);
		
		// 1年前
		DateUtils.addYears(date, -1);
		
		// 日期四舍五入 ,按照日期
		DateUtils.round(date, Calendar.SECOND);
		DateUtils.round(date, Calendar.MINUTE);
		
		// 日期裁剪,按照日期
		DateUtils.truncate(date, Calendar.HOUR);
		DateUtils.truncate(date, Calendar.DATE);
		
		// 日期向上取整
		DateUtils.ceiling(date, Calendar.DAY_OF_WEEK);
		DateUtils.ceiling(date, Calendar.MONTH);
		
		// 判断是否是同一天
		Date date1 = DateUtils.parseDate("2010/01/01 11:22:33", "yyyy/MM/dd HH:mm:ss");
		Date date2 = DateUtils.parseDate("2010/01/01 22:33:44", "yyyy/MM/dd HH:mm:ss");
		DateUtils.isSameDay(date1, date2);			// true
		
		
		// 转为日历对象
		Calendar calendar = DateUtils.toCalendar(date);
		
		// 格式化
		DateFormatUtils.format(date, "yyyy/MM/dd HH:mm:ss");
		

	}
}
