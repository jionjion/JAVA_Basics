package java8.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;

/**
 * @author Jion
 *  Period  日期之间的差
 */
public class PeriodTest {

    @Test
    public void test(){
        LocalDate now = LocalDate.now();
        LocalDate date = now.of(2019, 1, 1);

        Period between = Period.between(date, now);
        System.out.println("日期差: " + between);
        System.out.println("年份差: " + between.getYears());
        System.out.println("月份差: " + between.getMonths());
        System.out.println("天份差: " + between.getDays());
    }
}
