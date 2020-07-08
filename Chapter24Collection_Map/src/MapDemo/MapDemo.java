package MapDemo;

import org.junit.Test;

import java.util.*;

/**
 * @author : liulinzhi
 * @date: 2020/07/07/9:13
 * @description:
 */

/*1.Map接口：双列数据，存储key-value 键值对
            HashMap：主要实现类，线程不安全，效率高；
                     可以存null的key或value，底层
                     JDK7：数组加链表
                     JDK8：数组+链表+红黑树
                    LinkedeHashMap：保证遍历map时按照
                        添加的顺序实现遍历，因为底层基础上
                        添加了双向链表。频繁的遍历操作，
                        效率高于HashMap
            TreeMap：保证按照添加的key-value排序，实现
                    排序遍历（key的自然排序或定制排序）。
                    底层是红黑树
            Hashtable：古老实现类，线程安全，效率低；
                       不可以存null的key或value
                    Properties：常用来处理配置文件。
                            key和value都是String

        */
/*2.key value：
    Map中的key：无序，不可重复，使用Set存储所有key
            --重写hashCode和equals方法（HashMap）或（TreeMap）比较器
    Map中的value：无序，可重复，使用Collection存储
                   一个键值对：key-value构成一个Entry对象
                    --重写equals方法
    Map中的Entry：无序的，不可重复，使用Set存储所有Entry

 */
/*3.HashMap底层原理：
    JDK7：
        HashMap map = new HashMap();
        底层创建了长度为16的数组table，类型为Entry[]
        ..已经多次put..
        map.put(key1,value1)：
            首先，计算key1的hashCode方法，得到哈希值，此
                值经过某种方法得到在Entry中的存储位置：
   情况1----如果该位置为空，——key1-value1直接添加成功
            如果该位置不为空（一个或多个）
                比较key1和存在一个或多个数据的hash值：
   情况2----        都不同：——以链表形式添加成功
                    和某一个相同，继续比较key的equals方法：
                        如果相同：value替换当前的value
    情况3----             不同：——添加成功


    补充：关于情况2、3：链表存储在该位置
        扩容问题：默认扩容为2倍

    JDK8：
        底层的不同：
        1.new HashMap()：底层没有创建长为16的数组
        2.底层数组存储Node[]类型，不是Entry了
        3.put方法：首次调用时创建长为16的数组（类似ArrayList）
        4.加入了红黑树
            当数组的某一个索引位置的元素以链表形式
            存在的数据个数大于8且当前数组长度大于64
            时候，此索引位置的数据改用红黑树存储；
            因为logN效率高
 */
/*4.源码：
    JDK7：

 */
/*
 final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            //首次添加，创建底层数组table
            n = (tab = resize()).length;
          //该索引位置每有元素
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;//都相同放到e中
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {//就一个元素
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);//超过阈值变成红黑树
                        break;
                    }
                    /不止一个元素就继续比较
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;//换下一个node
                }
            }
            //替换value
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }


 */
/*
    Set keySet():返回所有key构成的Set集合
    Collection values():返回所有value构成的Collection集合
    Set entrySet():返回所有key-value对构成的Set集合
 */
/*
 */

public class MapDemo {
    @Test
    public void test1(){
        Map map = new LinkedHashMap();
        map.put(null,null);//没问题

        Map table = new Hashtable();
//        table.put(null,null);出错

    }
    @Test
    public void test2(){
        //遍历
        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        //没有iterator了
        //遍历key
        Set set = map.keySet();
        Iterator it = set.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        //遍历value
        Collection col = map.values();
        Iterator it1 = col.iterator();
        while (it1.hasNext())
            System.out.println(it1.next());
        //遍历entry
        Set set1 = map.entrySet();
        Iterator it2 = set1.iterator();
        while (it2.hasNext()){
            Object o = it2.next();
            Map.Entry entry = (Map.Entry) o;
            //entry有getKey和getValue方法
            System.out.println(entry.getKey() + "-" + entry.getValue());

    }}

}
