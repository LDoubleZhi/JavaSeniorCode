package exer;

/**
 * @author : liulinzhi
 * @date: 2020/07/01/11:13
 * @description:生产者消费者问题 1.是否是多线程：是，生产者线程，消费者线程
 * 2.线程安全问题：因为有共享数据，所以有
 * 3.如何解决线程安全问题：同步机制，三种方法
 * 4.线程间通信，wait notify
 */
class Clerk {
    private int productCount = 0;

    public synchronized void produceProduct() {
        if (productCount < 20) {
            System.out.println("生产者" + Thread.currentThread().getName()
                    + "开始生产第" + productCount +"个产品");
            productCount++;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if (productCount > 0) {
            System.out.println("消费者" + Thread.currentThread().getName()
                    + "开始消费第" + productCount +"个产品");
            productCount--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Producer extends Thread {
    private Clerk clerk;

    @Override
    public void run() {
        System.out.println("生产者" + Thread.currentThread().getName() + "开始生产产品");
        while (true) {
            clerk.produceProduct();
        }
    }

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

}

class Concumer extends Thread {
    private Clerk clerk;

    @Override
    public void run() {
        System.out.println("消费者" + Thread.currentThread().getName() + "开始生产产品");
        while (true) {
            clerk.consumeProduct();
        }
    }

    public Concumer(Clerk clerk) {
        this.clerk = clerk;
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();//锁唯一

        Producer p1 = new Producer(clerk);
        p1.setName("生产者");

        Concumer c1 = new Concumer(clerk);
        c1.setName("消费者");

        p1.start();
        c1.start();


    }
}
