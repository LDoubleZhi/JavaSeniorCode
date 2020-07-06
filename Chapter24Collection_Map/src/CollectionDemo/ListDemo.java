package CollectionDemo;

import org.junit.Test;

import java.util.*;

/**
 * @author : liulinzhi
 * @date: 2020/07/06/8:44
 * @description:List接口
 *
 */
/*
1.List接口常用实现类：有序可重复
    ArrayList：List的主要实现类（常用），
               线程不安全，效率高，底层使用Object[]；
    LinkedList：底层是双向链表，增删快，get慢，
                Node<E> first,last;
    Vector：List的古老实现类，线程安全，效率低；
            底层使用Object[]
  同：都是List接口的实现类，存储数据的特点相同
  不同：
        */

/*2.ArrayList源码：
    JDK7：
    //底层创建长度为10的数组
    ArrayList al = new ArrayList();
    //如果添加导致空间不足，需要扩容，默认1.5倍
    //将原数组数据复制到新数组中
    add（）
    //所以建议使用带参构造器，指定容量

    JDK8：
    //空参构造函数没有创建数组，{}
    //add中判断，第一次添加才创建10长度数组
    //后续添加、扩容和7相同

   小结：8对象的创建类似懒汉模式，延迟了数组
   的创建，节省资源

        */

/*3.LinkedList源码：
    //一个Node<E>类（双向链表）存储：数据，前指针，后指针
    new LinkedList()
    //封装该参数为Node对象，添加
    add(123)

        */

/*4.Vector源码：
    空参创建长为10的数组；扩容时默认2倍
    synchronized修饰方法：即使线程不安全
    工程中一般也不用他，而是把ArrayList放入
    Collections工具类中的synchronizedList(List)

        */

/*5.常用方法

        */

/*6.遍历和总结

 */

/*7面试题

 */
public class ListDemo {
    @Test
    public void test1(){

        //1.add
        ArrayList list = new ArrayList();
        list.add("a");
        list.add(true);
        list.add(new String("Tom"));
        list.add("d");
        list.add(new Person("jerry", 20));
        System.out.println(list);

        //2.add(index, ele)
        list.add(1, "asf");
        System.out.println(list);

        //3.addAll(Collection c),添加c中元素
        List l1 = Arrays.asList(1,2,3);
        list.addAll(l1);
        System.out.println(list);
//[a, asf, true, Tom, d, Person{name='jerry', age=20}, 1, 2, 3]

        //4.get
        System.out.println(list.get(1));//asf
        //5，indexOf
        System.out.println(list.indexOf("asf"));
        //1

        //6.lastIndexOf
        list.add("asf");
        System.out.println(list.lastIndexOf("asf"));
        //9

        //7.remove
        list.remove(0);
        System.out.println(list);
//        [asf, true, Tom, d, Person{name='jerry', age=20}, 1, 2, 3, asf]

        //8.set
        list.set(1, "asdfa");
        System.out.println(list);
//        [asf, asdfa, Tom, d, Person{name='jerry', age=20}, 1, 2, 3, asf]

        //9.subList
        System.out.println(list.subList(1, 5));
//        [asdfa, Tom, d, Person{name='jerry', age=20}]


    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add("a");
        list.add(true);
        list.add(new String("Tom"));
        list.add("d");
        list.add(new Person("jerry", 20));

        //迭代器遍历
        Iterator it = list.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        //增强for
        for(Object o : list)
            System.out.println(o);


    }
}
