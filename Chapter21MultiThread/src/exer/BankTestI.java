package exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : liulinzhi
 * @date: 2020/07/01/10:33
 * @description:
 */
class BankDemo implements Runnable
{
    private int store = 3000;
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while(true)
        {   try{
            lock.lock();

            if (store != 0)
                System.out.println(Thread.currentThread().getName()
            +  "now bank have "+ store +" store 1000;" );
            else
                break;
            store -= 1000;
        }finally{
            lock.unlock();
        }
        }
    }
}

public class BankTestI {
    public static void main(String[] args) {
        BankDemo b = new BankDemo();

        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
