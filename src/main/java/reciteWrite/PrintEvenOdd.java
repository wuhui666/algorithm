package reciteWrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wuhui
 * @time: 2019/11/12 12:56
 * @desc:
 */
public class PrintEvenOdd {
    private static int state=0;
    private static Lock lock=new ReentrantLock();

    public void printEven(){

        for (; state <20 ; ) {//打印限制
            while (state%2==0){//阻塞直到满足条件继续抢锁
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"--"+state);
                ++state;
                lock.unlock();
            }
        }


    }
    public void printOdd(){

        for (; state <20 ; ) {//打印限制
            while (state%2==1){
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"--"+state);
                ++state;
                lock.unlock();
            }
        }


    }
    public static void main(String[] args) {
        PrintEvenOdd printEvenOdd =new PrintEvenOdd();
        Runnable target;
        Thread t1=new Thread(printEvenOdd::printEven);
        Thread t2=new Thread(printEvenOdd::printOdd);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
