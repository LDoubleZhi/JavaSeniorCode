package DateDemo;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

/**
 * @author : liulinzhi
 * @date: 2020/07/03/15:25
 * @description:
 */
/*
1.LocalDate,LocalTime,LocalDateTime
    说明：LocalDateTime常用；
        */

/*


 */
public class JDK8Date {
    @Test
    public void test1(){
        //now():获取当前时间
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ld +"   " + lt + "  " + ldt);
        //2020-07-03   15:37:57.606  2020-07-03T15:37:57.606

        //of指定时间的对象
        LocalDateTime ldt1 = LocalDateTime.of(2020,10,6,13,23,43);
        System.out.println(ldt1);
        //2020-10-06T13:23:43

        //getXxx（）
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.getDayOfYear());
        System.out.println(ldt.getHour());
//        3
//        FRIDAY
//        185
//        15

        //withXxx：设置相关时间,不可变性，变得是返回值
        LocalDateTime ldt2 = ldt.withDayOfMonth(22);
        System.out.println(ldt2);
        System.out.println(ldt);
//        2020-07-22T15:46:10.660
//        2020-07-03T15:46:10.660

        //plusXxx()加
        LocalDateTime ldt3 = ldt.plusMonths(3);
        System.out.println(ldt3);
        System.out.println(ldt);
//        2020-10-03T15:48:56.755
//        2020-07-03T15:48:56.755

        //minusXxx()减
        LocalDateTime ldt4 = ldt.minusDays(3);
        System.out.println(ldt4);
        System.out.println(ldt);
//        2020-06-30T15:49:49.061
//        2020-07-03T15:49:49.061



    }

    @Test
    public void test2(){
        //now（）获取本初子午线时间
        Instant in = Instant.now();
        System.out.println(in);
//        2020-07-03T07:56:07.480Z

        //本初子午线+8个小时，为东8区
        OffsetDateTime o = in.atOffset(ZoneOffset.ofHours(8));
        System.out.println(o);
//        2020-07-03T15:59:12.461+08:00

        //从1970.1.1.0.0.0到现在的毫秒数 （UTC）
        Long in1 = in.toEpochMilli();
        System.out.println(in1);
//        1593763318134

        //毫秒数转回时间
        Instant in2 = Instant.ofEpochMilli(1593763318134L);
        System.out.println(in2);
        //2020-07-03T08:01:58.134Z
    }

    @Test
    public void test3(){
        //三种初始化方式,一般自定义方法
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
        String str = d.format(LocalDateTime.now());
        System.out.println(str);
        //2020-32-03 04:32:04
        TemporalAccessor ac = d.parse(str);
        System.out.println(ac);
//        {HourOfAmPm=4, DayOfMonth=3, MilliOfSecond=0, SecondOfMinute=48, MinuteOfHou
    }
}
