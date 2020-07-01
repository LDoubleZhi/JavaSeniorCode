package exer;

/**
 * @author : liulinzhi
 * @date: 2020/07/01/9:05
 * @description:用同步机制改写懒汉式
 */
class Bank{
    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance() {
        //Bank.class作为锁
//        synchronized (Bank.class) {效率差
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }

        if(instance ==null)
        {
            synchronized (Bank.class){
            if (instance == null) {
                instance = new Bank();
            }
        }}
        return instance;
        }
}
public class BankTest {
    public static void main(String[] args) {
        Bank.getInstance();
    }
}
