package mc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Count = in.nextInt();
        for(int count=0;count<Count;count++){
            int N = in.nextInt();
            int P = in.nextInt();
            int W = in.nextInt();
            int H = in.nextInt();
            int[] number = new int[N];
            int sum=0;
            for(int i=0;i<N;i++){
                number[i] = in.nextInt();
                sum+= number[i];

            }
            int init = Math.min(W,H);
            int result = 0;
            for(int size=init;size>0;size--){
                int w_count = W/size;
                int h_count = H/size;
                int one_count = w_count*h_count;
                int nu = sum/one_count;
                int yu = sum%one_count;
                if(yu>0){
                    nu++;
                }
                if(nu<=P){
                   result = size;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}