package CompareDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : liulinzhi
 * @date: 2020/07/03/16:37
 * @description:
 */
/*
  1.Comparable接口：
        1）包装类和String等实现了Comparable接口，
        重写了compareTo，给出了比较方式
        比如String重写了compareTo方法
        public int compareTo(String anotherString) {
        int len1 = value.length;
        int len2 = anotherString.value.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = anotherString.value;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
        2）规则：重写compareTo方法，根据返回值判断大小
        3）自定义类实现：
        如果需要排序可以让自定义类实现Comparaable接口，
        从写compareTo方法，指明如何排序
        @Override
    public int compareTo(Object o) {
        if(o instanceof Goods)
        {
            Goods goods = (Goods) o;
            return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致");

    }


    2.Comparator接口：
        1)重写compare（object o1,object o2）方法

   3.
        */
public class ComparableDemo {



    @Test
    public void test(){
        String[] arr = new String[]{"aa", "gg", "ee","asf"};
        //String重写了compareTo方法，
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //[aa, asf, ee, gg]
    }

    @Test
    public void test1(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("liangxiang", 34);
        arr[1] = new Goods("dellMouse", 34);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
//        [Goods{name='xiaomiMouse', price=12.0}, Goods{name='liangxiang', price=34.0}, Goods{name='dellMouse', price=43.0}, Goods{name='huaweiMouse', price=65.0}]
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("liangxiang", 34);
        arr[1] = new Goods("dellMouse", 34);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);

        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //name由小到大，相同则按照价格从高到低
                if(o1 instanceof Goods && o2 instanceof Goods)
                {
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName()))
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    else
                        return g1.getName().compareTo(g2.getName());
                }
               throw new RuntimeException("输入类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
//
    }
}
