package exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : liulinzhi
 * @date: 2020/07/01/10:44
 * @description:两个线程交替打印
 * wait():当前线程进入阻塞，释放同步监视器
 * notify():一旦执行该方法，唤醒被wait的一个线程，如果
 * 多个线程被wait，唤醒优先级最高的
 * notifyAll():唤醒所有wait线程
 *
 * 注意：线程同行：
 * 1.只能用在同步代码块或同步方法用。
 * 2.这三个方法的调用者必须是同步监视器（锁），否则报错
 * 3.三个方法定义在java.lang.Object类，
 * 因为任何一个类对象都可以做锁，故定义在Object类
 * 才能任意对象调用这三个方法
 *
 */
class Number implements Runnable
{
    private int number = 1;

    @Override
    public void run() {
        while(true)
        {
            synchronized (this) {
                notify();//唤醒一个线程，看优先级
                if (number <=100) {
                    System.out.println(Thread.currentThread().getName()
                            + " number: " + number);
                    number++;

                    try {
                        wait();//调用该方法的线程阻塞，释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else
                    break;
            }
        }
        }
    }

public class CommunicationTest {
    public static void main(String[] args) {
        Number b = new Number();

        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
