package jd;

import java.util.Scanner;

/**
 * Created by LiangJ on 2016/4/8.
 */
public class two {
    public static void  main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int number = in.nextInt();
            int size = in.nextInt();

            int[] candi = new int[number+1];
            int[] value = new int[number+1];

            for(int i=1;i<=number;i++){
                candi[i] = in.nextInt();
                value[i] = in.nextInt();
            }

            int[][] dp = new int[number+1][size+1];
            dp[0][0] = 0;
            for(int j=1;j<=number;j++) {
                for (int s = candi[j]; s <= size; s++) {
                    dp[j][s] = Math.max(dp[j - 1][s], dp[j - 1][s - candi[j]] + value[j]);

                }
            }
            if(dp[number][size]>0){
                System.out.println(dp[number][size]);
                int j = size;
                int[] result = new int[number];
                int position = number-1;
                for(int i=number-1;i>0&&j>0;i--){
                    if(dp[i][j]>dp[i-1][j]){
                        result[position--] = i;
                        j = j-value[i];
                    }
                }
                for(int i=position+1;i<number-1;i++){
                    System.out.print(result[i]+" ");
                }
                System.out.print(result[number-1]);
            } else {
                System.out.println(0);
                System.out.println("No");
            }

        }
    }
}
