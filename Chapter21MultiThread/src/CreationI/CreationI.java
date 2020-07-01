package CreationI;

/**
 * @author : liulinzhi
 * @date: 2020/06/29/19:40
 * @description:
 */
class MyThread extends Thread{
    //2
    @Override
    public void run() {
        //线程要作的事：
        for (int i=0;i<100;i++)
        {
            if(i%2==0)
                System.out.println(Thread.currentThread().getName() + ":"+ i);
        }
    }
}

public class CreationI {
    public static void main(String[] args) {
        //3
        MyThread t1 = new MyThread();
        //4
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();//java.lang.IllegalThreadStateException
//        t1.run();
        for (int i=0;i<100;i++)
        {
            if(i%2!=0)
                System.out.println(Thread.currentThread().getName() + ":"+"***"+i);
        }

    }
}