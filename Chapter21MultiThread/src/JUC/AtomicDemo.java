package JUC;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : liulinzhi
 * @date: 2020/07/01/15:18
 * @description:原子性问题
 * 1.i++的原子性问题：读-改-写三部操作
 * j = i++本质上在底层 int temp = i; i = i+1; j =temp;
 *
 * 解决方式：原子变量：java.util.concurrent.atomic包
 * 提供了大量常用的原子变量：
 * 1.有volatile特性，里面都用这个修饰，保证的内存可见性
 * 2.CAS（compare and swap）算法保证数据的原子性:
 * 他是硬件对并发操作共享数据的支持，底层的支持：
 * 包含了三个操作数：
 * 内存值V
 * 预估值A
 * 更新值B
 * 当前仅当V==A时，V=B，否则不做任何操作
 */
class Atomic implements Runnable{
    private AtomicInteger num = new AtomicInteger(0);

    public int getNum(){
        return num.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()
        + "  :" + getNum());
    }
}

public class AtomicDemo {
    public static void main(String[] args) {
        Atomic a1 = new Atomic();

        for (int i = 10; i>0; i--)
            new Thread(a1).start();
    }
}
