package test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by LiangJ on 2016/3/28.
 */
public class poolTest {
    public final BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
    public final AtomicInteger rc = new AtomicInteger();
    public final AtomicInteger wc = new AtomicInteger();
    public final ExecutorService pool = Executors.newFixedThreadPool(5);
    int randomTime(){
        return (int)Math.random()*1000;
    }
    public static void main(String[] args){
        poolTest test = new poolTest();
        test.run();

    }
    public void run(){
        pool.submit(new Write());
        for(int i=0;i<4;i++){
            pool.submit(new Thread(new Read()));
        }
        pool.shutdown();
    }

    class Write extends Thread {
        public void run() {
            while (rc.intValue() < 9) {
                try {
                    queue.put(rc.intValue());
                    System.out.println("write thread has put " + (rc.intValue()));
                    Thread.sleep(500);
                    rc.incrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                queue.put(-1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class Read implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(300);
                    int index = wc.incrementAndGet();
                    int value = queue.take();
                    System.out.println("Read "+Thread.currentThread().getName()+" has take"+index+" and the value is "+value);
                    if(value==-1){
                        queue.put(-1);
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread has complete");
        }
    }
}


