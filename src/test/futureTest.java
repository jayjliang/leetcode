package test;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.*;

/**
 * Created by LiangJ on 2016/3/28.
 */
public class futureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService pool = Executors.newFixedThreadPool(5);
        System.out.println("main thread start");
        Future<String> task = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("strt new Thread");
                Thread.sleep(5000);
                System.out.println("end new Thread ");
                return "some value";
            }
        });
        System.out.println("ok");
        Thread.sleep(2000);
        System.out.println("start");
        System.out.println(task.get());
        pool.shutdown();
        pool.awaitTermination(Long.MAX_VALUE,TimeUnit.DAYS);
        System.out.println("main thread end");
    }
}
