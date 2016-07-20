package wangyi2016;

import java.util.Scanner;

/**
 * Created by LiangJ on 2016/3/21.
 */
public class one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int number = in.nextInt();
            int init = in.nextInt();
            int[] beat = new int[number];
            for (int i=0;i<number;i++){
                beat[i] = in.nextInt();
            }
            System.out.println(new one().solution(beat,number,init));
        }
    }

    public int solution(int[] beat,int number,int init){
        for(int i=0;i<number;i++){
            if(beat[i]>init){
                init += getNumber(beat[i],init);
            } else {
                init += beat[i];
            }
        }
        return init;
    }

    public int getNumber(int a,int b){
        while(b!=0){
            int c = a%b;
            a=b;
            b=c;
        }
        return a;
    }
}
