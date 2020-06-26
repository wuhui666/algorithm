package reciteWrite;

import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wuhui
 * @time: 2019/9/30 16:30
 * @desc:
 */
class Producer implements Runnable{
    private final Vector<Integer> sharedQueue;
    private final int SIZE;
    private static AtomicInteger data=new AtomicInteger() ;
    private boolean running=true ;


    public Producer(Vector<Integer> sharedQueue,int size) {
        this.SIZE=size;
        this.sharedQueue=sharedQueue;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (running){
                Thread.sleep(random.nextInt(1000));
                // 这里不能用if，因为可能存在多个生产者
                // 被唤醒后，如果恰好其他生产者率先又添满了
                // 此时本线程应该继续阻塞保持wait
                // 用if会唤醒后直接执行后面代码，造成队列超出size
                while (sharedQueue.size()==SIZE){
                    synchronized (sharedQueue){
                        System.out.println(Thread.currentThread().getName()+" :queue is full");
                        // 等待消耗了唤醒
                        sharedQueue.wait();
                    }
                }
                synchronized (sharedQueue){
                    int item=data.incrementAndGet();
                    sharedQueue.add(item);
                    System.out.println(Thread.currentThread().getName()+" :put "+item+"th item in shared queue");
                    sharedQueue.notifyAll();
                }

            }
        }catch (InterruptedException e) {
            // 异常中断
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }

    public void stopRunning(){
        this.running=false;
        System.out.println(Thread.currentThread().getName()+" :stopped");
    }
}
class Consumer implements Runnable{
    private final Vector<Integer> sharedQueue;
    private final int size;
    private boolean running=true;

    public Consumer(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.size = size;
    }

    @Override
    public void run() {
        Random random=new Random();
        try {
            while (running){
                Thread.sleep(random.nextInt(1000));
                // 空了
                while (sharedQueue.isEmpty()){
                    synchronized (sharedQueue){
                        System.out.println(Thread.currentThread().getName()+" :queue is empty");
                        // 等待生产了唤醒
                        sharedQueue.wait();
                    }
                }
                synchronized (sharedQueue){
                    System.out.println(Thread.currentThread().getName()
                            +" :get "+sharedQueue.remove(0)
                            +"th item from shared queue");
                    sharedQueue.notifyAll();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    public void stopRunning(){
        this.running=false;
        System.out.println(Thread.currentThread().getName()+" :stopped");

    }
}
public class ProducerAndConsumer {

    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector=new Vector<>();
        int size=6;
        Producer p1=new Producer(vector, size);
        Producer p2=new Producer(vector, size);
        Producer p3=new Producer(vector, size);
        Consumer c1=new Consumer(vector, size);
        Consumer c2=new Consumer(vector, size);
        Consumer c3=new Consumer(vector, size);
        //ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(6, 10, 20000, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<>(6));
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);
        executorService.execute(c1);
        executorService.execute(c2);
        executorService.execute(c3);

        Thread.sleep(9000);
        // 停止放东西，c1,c2,c3消耗完阻塞
        p1.stopRunning();
        p2.stopRunning();
        p3.stopRunning();
        Thread.sleep(9000);
        // 强制关闭阻塞的线程（c1,c2,c3不可能被唤醒了，需要强制关闭）
        executorService.shutdownNow();

    }
}
