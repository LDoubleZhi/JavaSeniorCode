package StringBuffer;

import org.junit.Test;

/**
 * @author : liulinzhi
 * @date: 2020/07/03/9:13
 * @description:
 * 1.String StringBuffer StringBuilder三者的异同
 * String：不可变（final实际返回一个新对象）的字符序列；底层使用char[]型数组；
 * StringBuffer：可变(直接改内容)的字符序列；底层使用char[]型数组
 *              线程安全（加了synchronized），效率低
 * StringBuilder：可变的字符序列；JDK5，底层使用char[]型数组
 *                  线程不安全，效率高。
 *
 */
/*
源码分析：
String str = new String();
//new char[0]
String str1 = new String("abc");
//new char[]{'a', 'b', 'c'}

父类AbstractStringBuilder:char[] value;
StringBuffer sb1 = new StringBuffer();
//new char[16]
sb1.append('a');
//value[0] = 'a';

StringBuffer sb2 = new StringBuffer("abc");
//super(str.length() + 16);append(str);

问题1： System.out.println(sb2.length());
//3,length():return count;
//The count is the number of characters used.

问题2：扩容问题，如果append底层存不下了，那就需要扩容：
默认扩容为原来2倍+2，同时将原来value复制到新数组

//append实际调用父类AbstractStringBuilder的append方法
public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        //str存到value数组
        count += len;
        //更新count
        return this;
    }

public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }
private void ensureCapacityInternal(int minimumCapacity) {
        // overflow-conscious code
        if (minimumCapacity - value.length > 0) {
            value = Arrays.copyOf(value,
                    newCapacity(minimumCapacity));
        }
    }
private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int newCapacity = (value.length << 1) + 2;
        //扩容2倍+2
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
            ? hugeCapacity(minCapacity)
            : newCapacity;
    }

问题3：StiringBuffer(int capacity)//指定容量

*/
public class SBDemo {
    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.setCharAt(0, 'm');
        System.out.println(s1);
    }

    public static void main(String[] args) {

    }
}
