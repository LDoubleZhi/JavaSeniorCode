package CreationI.CreationII;

/**
 * @author : liulinzhi
 * @date: 2020/06/30/10:37
 * @description:第二种多线程创建方式
 * 1.创建实现了Runnable接口的类
 * 2.实现类实现Runnable的run方法
 * 3.创建实现类的对象
 * 4.将此对象作为参数传到Thread类的构造器中，创建
 * Thread类对象，
 * 5.通过它调用start方法
 */
class MThread implements Runnable{
    @Override
    public void run(){
        for (int i=0;i<100;i++)
        {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority() +"+:"+ i);

            }
    }
}}

public class CreationII {
    public static void main(String[] args) {
        MThread t = new MThread();
        Thread t1 = new Thread(t);
        t1.start();
        Thread t2 = new Thread(t);
        t2.start();


    }
}
