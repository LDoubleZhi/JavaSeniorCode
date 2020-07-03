package DateDemo;

import org.junit.Test;

//import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : liulinzhi
 * @date: 2020/07/03/10:24
 * @description:旧日期
 */
/*
java.util.Date类
        |---java.sql.Date类
1.两个构造器的使用

2.两个方法的使用
    toString（）：显示年、月、日、时、分、秒
    getTime（）：获取当前Date对象对应的时间戳

3.java.sql.Date对应着数据库交互中的日期类型的变量

4.两个Date的相互转换：
        Date d1 = new java.util.Date(12313132L);
        java.sql.Date d2 = new java.sql.Date(d1.getTime())
*/

/*
3.SimpleDateFormat:对日期Date类的格式化
   1.   1）格式化：日期---》字符串
        2）解析：字符串----》日期
   2.实例化：
        //格式化日期：
        Date date = new Date();
        System.out.println(date.toString());
        //Fri Jul 03 14:55:28 CST 2020

        String s = adf.format(date);
        System.out.println(s);
        //20-7-3 下午2:55

        Date date1 = new Date();
        date1 = adf.parse(s);
        System.out.println(date1);
        //Fri Jul 03 14:58:00 CST 2020

        带参数的自定义SimpleDateFormat（pattern）
        比如数据库中写入
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(birth);
        java.sql.Date d2 = new java.sql.Date(d.getTime())
        //转为sql的date

        */

/*4.Calendar抽象类：
    1.实例化:
        Calendar c = Calendar.getInstance();
        System.out.println(c.getClass());
        //class java.util.GregorianCalendar

        或创建子类对象GregorianCalendar对象
    2.常用方法：对自定义的final常量设置
        //get（）
        int days = c.get(Calendar.DAY_OF_MONTH);

        //set（）
        c.set(Calendar.DAY_OF_MONTH, 22);

        //add（）
        c.add(Calendar.DAY_OF_MONTH, 3);

        //getIime（）转为Date类对象
        Date date = c.getTime()；

        //setTime（）
        Date date = new Date()；
        c.setTime(date1);



        */
public class OldDate {
    @Test
    public void test(){
        //构造器一：Date(),先测util包的;
        //创建了一个对应当前时间的Date对象
        Date d1 = new Date();
        System.out.println(d1.toString());
        //Fri Jul 03 10:28:43 CST 2020
        System.out.println(d1.getTime());
        //距离1970.1.1.0.0.0的毫秒

    }

    @Test
    public void test1(){
        //构造器二：Date(),先测sql包的
        //创建指定毫秒数的Date
        Date d1 = new java.sql.Date(564597896L);
        System.out.println(d1.toString());
        //1970-01-07
        System.out.println(d1.getTime());
        //564597896
    }

    @Test
    public void test2() throws ParseException {
        SimpleDateFormat adf = new SimpleDateFormat();

        //格式化日期：
        Date date = new Date();
        System.out.println(date.toString());
        //Fri Jul 03 14:55:28 CST 2020

        String s = adf.format(date);
        System.out.println(s);
        //20-7-3 下午2:55

        Date date1 = new Date();
        date1 = adf.parse(s);
        System.out.println(date1);
        //Fri Jul 03 14:58:00 CST 2020



    }

    @Test
    public void test3(){
        Calendar c = Calendar.getInstance();
        System.out.println(c.getClass());
        //class java.util.GregorianCalendar

        int days = c.get(Calendar.DAY_OF_MONTH);
    }

}
