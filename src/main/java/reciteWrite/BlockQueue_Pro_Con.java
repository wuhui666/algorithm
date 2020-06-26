package reciteWrite;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wuhui
 * @time: 2019/9/30 22:51
 * @desc:
 */
class Producer2 implements Runnable{
    private final BlockingQueue<Integer> sharedQueue;
    private boolean running=true;
    private static AtomicInteger data=new AtomicInteger();

    public Producer2(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        Random random=new Random();
        try {
            while (running){

                Thread.sleep(random.nextInt(1000));

                // 如果队列满了添加失败
                if (!sharedQueue.offer(data.incrementAndGet())){
                    System.out.println(Thread.currentThread().getName()+" :queue is full.add "+ data+" failed!");

                }
                else {
                    System.out.println(Thread.currentThread().getName()+" :put "+ data+"th item into  shared Queue!");

                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    public void stopRunning() {
        running=false;
    }
}
class Consumer2 implements Runnable{
    private final BlockingQueue<Integer> sharedQueue;
    private boolean running=true;
    private static AtomicInteger data=new AtomicInteger();

    public Consumer2(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        Random random=new Random();
        try {
            while (running){

                Thread.sleep(random.nextInt(1000));
                if (sharedQueue.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+" :queue is empty.");

                }
                else {
                    // 阻塞直到有东西可以拿
                    System.out.println(Thread.currentThread().getName()+" :get "+sharedQueue.poll(2, TimeUnit.SECONDS)+"th item from shared queue");

                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    public void stopRunning() {
        running=false;
    }
}
public class BlockQueue_Pro_Con {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue=new LinkedBlockingQueue<>(3);

        Producer2 p1=new Producer2(blockingQueue);
        Producer2 p2=new Producer2(blockingQueue);
        Producer2 p3=new Producer2(blockingQueue);
        Consumer2 c1=new Consumer2(blockingQueue);
        Consumer2 c2=new Consumer2(blockingQueue);
        Consumer2 c3=new Consumer2(blockingQueue);
        //ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(6, 10, 20000, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<>(6));
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);
        executorService.execute(c1);
        /*executorService.execute(c2);
        executorService.execute(c3);*/

        Thread.sleep(6000);
        // 停止放东西，c1,c2,c3消耗完阻塞
        p1.stopRunning();
        p2.stopRunning();
        p3.stopRunning();
        Thread.sleep(6000);
        // 强制关闭阻塞的线程（c1,c2,c3不可能被唤醒了，需要强制关闭）

        executorService.shutdownNow();
    }
}
