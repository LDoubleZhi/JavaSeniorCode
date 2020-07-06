package CollectionDemo;

import org.junit.Test;

import java.util.*;

/**
 * @author : liulinzhi
 * @date: 2020/07/05/11:41
 * @description:
 */

/*
Collection接口的常用方法：


*/
class Person{
    private String name;
    private int age;

    public Person(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class FunctionDemo {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        //1.add(E e):将元素e添加到集合中
        //2.size():获取元素个数
        coll.add("a");
        coll.add(true);
        coll.add(new String("Tom"));
        coll.add("d");
        coll.add(new Person("jerry", 20));
        System.out.println(coll.size());//5

        //3.addAll(Collection c):将c中元素添加到当前集合
        Collection coll1 = new ArrayList();
        coll1.add("e");
        coll1.add("f");
        coll1.addAll(coll);
        System.out.println(coll1.size());//7
        System.out.println(coll1);//因为重写了toString方法
//        [e, f, a, b, c, d, Sun Jul 05 11:50:13 CST 2020]

        //4.isEmpty():判断是否有元素
        System.out.println(coll1.isEmpty());
        //ArrayList.isEmpty返回（size==0）

        //5.clear():清空元素

        //6.contains(Object o):是否包含o对象,
        // 会调用o的equals方法判断
        System.out.println(coll.contains("a"));//true
        System.out.println(coll.contains(new String("Tom")));
        //true
        System.out.println(coll.contains(new Person("jerry", 20)));
        //false，重写Person的equals方法后为true

        //7.containsAll(Collection c):所有元素是否存在于当前集合中
        Collection coll2 = Arrays.asList("a", new Person("jerry", 20));
        System.out.println(coll.containsAll(coll2));
        //true

        //8.boolean remove(Object o):移除元素o，依据equals方法

        //9.removeAll(Collection coll):两个集合的差集

        //10.retainAll(Collection coll):两集合交集

        //11.equals(Collection coll):是否元素都相同并同序
        //因为ArrayList是有序的
        //12.int hashCode():返回当前对象哈希值，Object

        //13.Object[] toArray():集合转数组

        //14.Arrays.asList(数组):数组转集合List
        //注意包装类才有重写toString，几倍呢类型会识别为一个元素


    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add("a");
        coll.add(true);
        coll.add(new String("Tom"));
        coll.add("d");
        coll.add(new Person("jerry", 20));
        System.out.println(coll.size());//5

        //iterator()
        /*
            遍历：iterator接口:
            1.遍历：
            Iterator it = coll.iterator();//collection实现了该接口
            while(it.hasNext())
                System.out.println(it.next());

            2.错误方式：
            while(coll.iterator().hasNext())
                System.out.println(coll.iterator().next());
            //两次的迭代器是不一样的两个对象

            3.remove方法：注意不同于集合的remove，

            4.增强foreach：JDK5，针对数组和集合，本质用了迭代器
                 for(集合元素的类型 局部变量：集合对象)
        */
        Iterator it = coll.iterator();//collection实现了该接口
        while(it.hasNext())
            System.out.println(it.next());
        //for(集合元素的类型 局部变量：集合对象)
        for(Object o:coll)
        {
            System.out.println(o);
        }





    }
}
