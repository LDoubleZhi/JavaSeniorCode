package JUC;

/**
 * @author : liulinzhi
 * @date: 2020/07/01/14:54
 * @description:volatile关键字
 * 该关键字保证多个线程操作共享数据时候，内存中数据是可见的
 * 时刻刷新缓存数据到主存
 */
class Number implements Runnable {
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + isFlag());

    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        Number n = new Number();

        new Thread(n).start();

        //这里卡在flag=true，为什么分线程flag是
        //true而主线程一直循环？
        /*
        Jvm对每个线程都分配一个独立的缓存用于提高效率；
         */
        while (true) {
//            synchronized (n) {
            if (n.isFlag()) {
                System.out.println("---------");
                break;
            }
//            }
        }
    }
}
