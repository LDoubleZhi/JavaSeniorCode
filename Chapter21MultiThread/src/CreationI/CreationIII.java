package CreationI;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : liulinzhi
 * @date: 2020/07/01/12:06
 * @description:Callable接口创建线程
 * 1.创建Callable接口实现类
 * 2.实现call方法，线程要做的操作，可以有返回值
 * 3.创建Callable接口实现类的对象
 * 4.将该对象作为参数传入FutureTask构造器创建对象
 * 5.Thread构造器传入FT对象，调用start方法
 * 6.可以使用FT对象.get得到call()返回值
 *
 *
 * 理解Callable接口方式创建多线程比Runnable接口创建更强大？
 * 1.前者可以有返回值
 * 2.前者可以抛出异常，可以catch
 * 3.前者支持泛型
 * 4.
 */
class NumThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}

public class CreationIII {
    public static void main(String[] args) {
        NumThread n = new NumThread();

        FutureTask f = new FutureTask(n);//又封装一层

        new Thread(f).start();
        //因为FurueTask实现了Runnable接口

        try {
            Object sum = f.get();//返回值就是FutureTask
            //构造器参数Callable实现类重写的call方法
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
