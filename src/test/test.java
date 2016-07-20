package test;
import java.io.IOException;
import java.nio.channels.Selector;

/**
 * Created by LiangJ on 2016/1/10.
 */
public class test {
    static int a=1;

    static {
        System.out.println("ok");
    }
    public test(){
        System.out.println(this.a);
    }
    public static void main(String[] args) {
        A b=new A();
        if(b.c==null){
            System.out.println("h");
        }
    }

}

class A {
    String c;
    public int a = method1();
    public static int b = method2();
    public A(){
        System.out.println(3);
    }
    public int method1(){
        System.out.println(1);
        return 1;
    }
    public static int method2(){
        System.out.println(2);
        return 2;
    }
}
class B extends A {
    public int a = method3();
    public static int b = method4();
    public B(){
        System.out.println(4);
    }
    public int method3(){
        System.out.println(5);
        return 1;
    }
    public static int method4(){
        System.out.println(6);
        return 2;
    }
}