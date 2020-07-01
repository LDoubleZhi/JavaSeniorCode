package Lock;

/**
 * @author : liulinzhi
 * @date: 2020/07/01/9:28
 * @description:死锁
 * 1.此时s1和s2被阻塞，形成死锁
 * 2.使用同步要避免死锁：
 */
public class Lock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        //
        new Thread(){
            @Override
            public void run()
            {
                synchronized (s1)
                {
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2)
                    {
                        s1.append("b");
                        s2.append("2");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();
        //匿名对象（实现Runnable接口的匿名类+new）
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2)
                {
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1)
                    {
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
