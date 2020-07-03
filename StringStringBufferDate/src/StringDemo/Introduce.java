package StringDemo;


import org.junit.Test;

/**
 * @author : liulinzhi
 * @date: 2020/07/02/16:05
 * @description:String介绍
 * 1.final类，不可继承
 * 2.实现了Serializable接口：表示支持序列化;
 *   实现了Comparable接口：可以比较String对象大小；
 * 3.String内部定义了final char【】用于存储字符串数据
 * 4.String：不可变的字符序列，
 *            体现：
 * 5.通过字面量方式赋值（和new有区别）时候，此时字符串值声明
 * 在字符串常量池中
 * 6.字符串常量池不会声明两个相同内容的字符串
 */
public class Introduce {
    @Test
    public void test1(){
        String s1 ="abc";//字面量的定义方式
        String s2 = "abc";
//        s1 = "hello";
        System.out.println(s1==s2);//true

        System.out.println(s1);//hello
        System.out.println(s2);//abc
        System.out.println("--------------");//abc

        String s3 = "abc";
        s3 += "def";

        System.out.println("--------------");
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc

    }

    public static void main(String[] args) {

    }
}
