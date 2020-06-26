package reciteWrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wuhui
 * @time: 2019/11/12 12:56
 * @desc:
 */
public class PrintABC {
    private static int state=0;
    private static Lock lock=new ReentrantLock();

    public void printADG(){

        for (; state <26 ; ) {//打印限制
            while (state%3==0){//阻塞直到满足条件继续抢锁
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"--"+(char)('A'+state));
                ++state;
                lock.unlock();
            }
        }


    }
    public void printBEH(){

        for (; state <26 ; ) {//打印限制
            while (state%3==1){//阻塞直到满足条件继续抢锁
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"--"+(char)('A'+state));
                ++state;
                lock.unlock();
            }
        }


    }
    public void printCFI(){

        for (; state <26 ; ) {//打印限制
            while (state%3==2){//阻塞直到满足条件继续抢锁
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"--"+(char)('A'+state));
                ++state;
                lock.unlock();
            }
        }


    }
    public static void main(String[] args) {
       PrintABC printABC=new PrintABC();
       //java 8 特性，相当于把该方法当成runnable的run方法，
        // 自动推断为Runnable r=()->{....}类型
        Thread t1=new Thread(printABC::printADG);
        Thread t2=new Thread(printABC::printBEH);
        Thread t3=new Thread(printABC::printCFI);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
