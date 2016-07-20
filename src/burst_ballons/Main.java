package burst_ballons;

/**
 * Created by LiangJ on 2016/4/7.
 */
public class Main {
    int[][] dp;
    int[] values;
    public static void main(String[] args){
        Main main = new Main();
        int[] num = {8,5,3,1};
        System.out.println(main.solution(num));
    }
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        dp = new int[n + 2][n + 2];

        //Initialize new array
        values = new int[n + 2];
        values[0] = values[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            values[i] = nums[i - 1];
        }

        return DP(1, n);
    }

    public int DP(int i, int j){
        if (dp[i][j] > 0) {//momorization
            return dp[i][j];
        }
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], DP(i, x - 1) + values[i-1]*values[x]*values[j+1] + DP(x + 1, j));
        }
        return dp[i][j];
    }

    public int solution(int[] nums){
        if(nums.length<1){
            return 0;
        }
        if(nums.length<2){
            return nums[0];
        }
        int len = nums.length;
        int[] newCoin = new int[len+2];
        newCoin[0] = 1;
        newCoin[len+1]=1;
        for(int i=1;i<len+1;i++){
            newCoin[i] = nums[i-1];
        }
        int[][] dp = new int[len+2][len+2];

        for(int k=1;k<=len;k++){
            for(int i=1;i<=len-k+1;i++){
                int j = i+k-1;
                for(int x=i;x<=j;x++){
                    dp[i][j] = Math.max(dp[i][j],dp[i][x-1]+dp[x+1][j]+newCoin[i-1]*newCoin[x]*newCoin[j+1]);
                }
            }
        }
        return dp[1][len];
    }

}
