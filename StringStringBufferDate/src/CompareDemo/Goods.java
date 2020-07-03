package CompareDemo;

import java.util.Comparator;

/**
 * @author : liulinzhi
 * @date: 2020/07/03/17:46
 * @description:
 */
public class Goods {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }



//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Goods)
//        {
//            Goods goods = (Goods) o;
//            return Double.compare(this.price, goods.price);
//        }
//        throw new RuntimeException("传入的数据类型不一致");
//
//    }

//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Goods)
//        {
//            Goods goods = (Goods) o;
//            if(this.price != goods.price)
//                return Double.compare(this.price, goods.price);
//            else
//                return this.name.compareTo(goods.name);
//        }
//        throw new RuntimeException("传入的数据类型不一致");
//
//    }

}
