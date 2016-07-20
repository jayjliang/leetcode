package wangyi2016;

import java.util.Scanner;

/**
 * Created by LiangJ on 2016/3/21.
 */
public class three {
    public int end_x;
    public int end_y;
    public int all_x;
    public int all_y;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int number = in.nextInt();
            int[] x = new int[number];
            int[] y = new int[number];
            for(int i=0;i<number;i++){
                x[i] = in.nextInt()-1;
                y[i] = in.nextInt()-1;
            }
            int[][] mo = new int[n][m];
            for(int i=0;i<number;i++){
                mo[x[i]][y[i]] ++;
            }
            three th = new three();
            int r1 = th.solution(n,m,number,mo);
            int r2 = th.solution(n,m,number,mo);
            System.out.println(r1+r2);
        }

    }

    public int solution(int n,int m,int number,int[][] mo){
        all_x = n;
        all_y = m;
        int max=0;
        for(int k=0;k<n;k++){
            for(int p=0;p<m;p++){
                int result = get_number(mo,k,p);
                if(result>=max){
                    max = result;
                    end_x = k;
                    end_y=p;
                }
            }
        }
        clear(mo);
        return max;
    }
    public void clear(int[][] mo){
        for(int a=end_x;a<end_x+3&&a<all_x;a++){
            for(int b=end_y;b<end_y+3&&b<all_y;b++){
                if(mo[a][b]>0){
                    mo[a][b]--;
                }
            }
        }
    }
    public int get_number(int[][] mo,int x1,int y1){
        int result=0;
        for(int i=x1;i<x1+3&&i<all_x;i++){
            for(int j=y1;j<y1+3&&j<all_y;j++){
                if(mo[i][j]>0){
                    result++;
                }
            }
        }
        System.out.println(x1+" "+y1+ ""+result);
        return result;
    }
}
