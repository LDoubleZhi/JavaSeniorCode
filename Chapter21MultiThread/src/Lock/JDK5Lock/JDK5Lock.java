package Lock.JDK5Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : liulinzhi
 * @date: 2020/07/01/9:53
 * @description:解决线程安全问题方式三：
 *1.实例化ReentrantLock对象；
 * 2.调用锁  lock
 * 3.解锁 unlock
 *
 * 对比：
 * synchronized和lock异动：
 * 同：二者都可以解决线程安全问题
 * 不同：前者自动释放锁（执行完同步代码块），后者手动释放
 * 建议优先用Lock->同步代码块（已经进入方法体，分配了资源）
 * ->同步方法（在方法体外）
 *
 * 如何解决线程安全问题？有几种？
 */
class Window implements Runnable {
    private int ticket = 100;

    //   turn:FIFO
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try{
                //2.调用lock
                lock.lock();

            if (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        + ":买票,票号：" + ticket);
                ticket--;
            }else
                break;
        }finally{
                //3解锁
                lock.unlock();
            }
        }
    }
}

public class JDK5Lock {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}
