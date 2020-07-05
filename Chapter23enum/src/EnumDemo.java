import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import javax.swing.*;

/**
 * @author : liulinzhi
 * @date: 2020/07/05/9:00
 * @description:
 */
/*定义枚举类：
    1.自定义枚举类：jdk5之前：

    2.jdk5时，使用用enum关键字定义枚举类：
    定义的枚举类默认继承自Enum类

    3.Enum类中的常用方法：
        */


/*
class Season{
    //1.属性为private final
    private final String seasonName;
    private final String seasonDesc;

    //2.构造器private
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;

    }
    //3提供当前枚举类的多个对象 public static final
    public static final Season spring = new Season("春天" ,"春暖花开");
    public static final Season Summer = new Season("夏天" ,"夏日炎炎");
    public static final Season Autumn = new Season("秋天" ,"秋高气爽");
    public static final Season Winter = new Season("冬天" ,"冰天雪地");

    //4.获取对象属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
*/
interface Info{
    void show();
}

enum SeasonEnum implements Info{
    //1.创建枚举类对象，多个对象之间逗号隔开，末尾用分号结束
    Spring("春天" ,"春暖花开"){
        @Override
        public void show() {
            System.out.println("Spring");
        }
    },
    Summer("夏天" ,"夏日炎炎"){
        @Override
        public void show() {
            System.out.println("Summer");
        }
    },
    Autumn("秋天" ,"秋高气爽"){
        @Override
        public void show() {
            System.out.println("Autumn");
        }
    },
    Winter("冬天" ,"冰天雪地"){
        @Override
        public void show() {
            System.out.println("Winter");
        }
    };


    //1.属性为private final
    private final String seasonName;
    private final String seasonDesc;

    //2.构造器private
    private SeasonEnum(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;

    }
    //3提供当前枚举类的多个对象 public static final

    //4.获取对象属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

}
public class EnumDemo {
    @Test
    public void test1(){
        SeasonEnum spring = SeasonEnum.Spring;
        System.out.println(spring);
        //Spring
        System.out.println(SeasonEnum.class.getSuperclass());
//       //class java.lang.Enum
    }

    @Test
    public void test2(){
        SeasonEnum[] values = SeasonEnum.values();

        for(int i=0;i<values.length;i++)
            System.out.println(values[i]);
//        Spring Summer Autumn Winter
        Thread.State[] v = Thread.State.values();
        for(int i=0;i<v.length;i++)
            System.out.println(v[i]);
//        NEW RUNNABLE  BLOCKED  WAITING TIMED_WAITING  TERMINATED
        SeasonEnum spring = SeasonEnum.valueOf("Winter");
        spring.show();
        System.out.println(spring);//Winter

    }

}
