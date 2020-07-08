package CollectionDemo;

import org.junit.Test;

import java.util.*;

/**
 * @author : liulinzhi
 * @date: 2020/07/06/10:23
 * @description:
 */
/*1.Set接口：无序不重复
    HashSet：Set接口主要实现类；线程不安全；可存null；
        LinkedHashSet:父类为HashSet；可以按照添加
                        的顺序遍历；
    TreeSet:可按照添加对象的指定属性排序
   同：
   不同：
        */

/*2.Set的无序和不可重复的理解：
    1）无序：不等于随机性。
        HashSet虽然无序但每次遍历输出都一样；
        存储的数据在底层数组中并非按照数组索引顺序添加。
        而是根据数据的哈希值添加。

    2）不可重复：
        添加的元素按equals方法判断时不能为true。

 */

/*3.HashSet添加过程
    先得到hash值，遍历前面元素，如果hash相同；
    接下来判断equals相同？-同则添加失败（重复），如果
    equals-false，不重复，这里冲突---拉链法（链表结构），

    所以无序性：由hashcode求存储位置，所以无序
    不可重复型：hashcode和equals相同，则添加失败

    步骤：
    向HashSet添加元素a，
        首先调用a所在类的hashCode方法，得到a的hash值；
        然后由这个hash值通过某种算法得到底层数组存储位置的
        索引，判断该位置是否有元素：
            如果没有：直接添加---1
            如果有：比较已有元素的hash值
                不同：添加a成功----2
                相同：调用a的equal方法比较
                    返回true：添加失败
                    返回false：添加a---3

            对于添加情况2和3：以链表形式存储
            JDK8：首次添加的元素在数组中，新来的放入该位置链表



 */

/*4.equals、hashCode
    idea可以直接添加自定义类中的hashCode和equals方法
    其他的Object就有hashCode和equals方法；
 */

/*5.LinkedHashSet：

 */

/*6.TreeSet：
    1.TreeSet添加的数据要求相同类的对象；
    2.两种排序方式：自然排序和定制排序
    3.比较相同用的是该类的compareTo方法是否返回0
    不再是equals方法；
    4.定制排序：new TreeSet(Comparaor c）

        */
public class SetDemo {
    @Test
    public void test1(){
        //定制排序：new TreeSet(Comparaor c）
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person)
                {
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return p1.compareTo(p2);
                }
                else
                    throw new RuntimeException("输入类型不对");
            }
        });
        //重写comparable接口的compareTo方法
        set.add(new Person("Ton", 12));
        set.add(new Person("jerry", 32));
        set.add(new Person("Jim", 2));
        set.add(new Person("Jim", 22));
        set.add(new Person("Mike", 65));
        set.add(new Person("Coder", 65));
        //出错，只能添加相同类的对象
//        set.add(true);
//        set.add(new String("Tom"));
//        set.add("d");
//        set.add(new Person("jerry", 20));
//        set.add(new Person("jerry", 20));

        Iterator it = set.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        //按add顺序输出



    }
}
