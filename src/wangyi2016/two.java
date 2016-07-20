package wangyi2016;

import java.util.Scanner;

/**
 * Created by LiangJ on 2016/3/21.
 */
public class two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int[] number = new int[9];
            for (int i = 0; i < 9; i++) {
                number[i] = in.nextInt();
            }
            System.out.println(new two().getHarm(number) + "x");
        }
    }
    public int getHarm(int[] number){
        int result=0;
        int r = number[0]*number[0];
        int d1 = get_distance(number[1],number[2],number[7],number[8]);
        int d2 = get_distance(number[3],number[4],number[7],number[8]);
        int d3 = get_distance(number[5],number[6],number[7],number[8]);
        if(r>=d1){
           result+=1;
        }
        if(r>=d2){
            result+=1;
        }
        if(r>=d3){
            result+=1;
        }
        return result;
    }

    public int get_distance(int x1,int y1,int x2,int y2){
        int x = Math.abs(x1-x2);
        int y = Math.abs(y1-y2);
        return x*x+y*y;
    }
}

