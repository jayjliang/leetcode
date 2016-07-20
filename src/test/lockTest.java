package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LiangJ on 2016/3/28.
 */
public class lockTest {
    static output output = new output();
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(4);
        final String[] name = {"hello","world","Java","hard"};
        /*for(int i=0;i<4;i++){
            pool.submit(new MyThread(name[i]));
        }
        pool.shutdown();*/
/*        final Outputter output = new Outputter();
        new Thread() {
            public void run() {
                output.output("zhangsan");
            }
        }.start();
        new Thread() {
            public void run() {
                output.output("lisi");
            }
        }.start();*/
        final Test test = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.sub2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.sub1();
            }
        }).start();
    }
}
class Outputter {
    public void output(String name) {
        // TODO 为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
        for(int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyThread extends Thread{
    String name;
    public MyThread(String name){
        this.name = name;
    }
    public void run(){
        lockTest.output.output(name);
    }
}
class output{
    private Lock lock = new ReentrantLock();
    public void output(String name){
        lock.lock();
        try{
            for (int i = 0; i < name.length(); i++) {
                System.out.println(name.charAt(i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e){

        }
        lock.unlock();
    }
}

class Test{
    public static int i=0;
    public static int conNum = 1;
    public static Lock lock = new ReentrantLock(false);
    public static Condition con1 = lock.newCondition();
    public static Condition con2 = lock.newCondition();
    public static Condition con3 = lock.newCondition();
    int count=0;
    public void sub1(){
        lock.lock();
        while (conNum!=1){
            try {
                con1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i++;
        System.out.println(i+",");
        conNum = 2;
        con2.signal();
        lock.unlock();
    }
    public void sub2(){
        lock.lock();
        System.out.println("enter sub2");
        while (conNum!=2){
            System.out.println("sub2 wait");
            try {
                con2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ok");
        }
        i = i+2;
        System.out.println(i+",");
        conNum = 3;
        con3.signal();
        lock.unlock();
    }
    public void sub3(){
        lock.lock();
        while (conNum!=3){
            try {
                con3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i = i+3;
        System.out.println(i+",");
        conNum = 1;
        con1.signal();
        lock.unlock();
    }
}
