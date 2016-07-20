package best_time_to_buy_and_sell_stock_with_cooldown;

/**
 * Created by LiangJ on 2016/3/8.
 */
public class main {
    public static void  main(String[] args){
        Solution s = new Solution();
        int[] price ={1,2,3,0,3,6,9,8,18};
        System.out.println(s.DpSolution(price));
    }
};
class  Solution{
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0){
            return 0;
        }
        int[] ss=new int[n];
        int[][] dp = new int[n][3];
        for(int i=1;i<n;i++){
            ss[i] = prices[i]-prices[i-1];
        }
        for(int j=1;j<n;j++){
            dp[j][0] = Math.max(dp[j-1][0]+ss[j],dp[j-1][2]+ss[j]);
            dp[j][1] = dp[j-1][0];
            dp[j][2] = Math.max(dp[j-1][1],dp[j-1][2]);
        }
//        System.out.println(dp[n-1][0]+" "+dp[n-1][1]+" "+dp[n-1][2]);
        return Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
    }

    public int DpSolution(int[] prices){
        int n = prices.length;
        if(n==0){
            return 0;
        }
        int lastHas,latNo,currentHas,currentNo;
        currentHas = lastHas = -prices[0];
        currentNo = latNo = 0;
        int prveNo = 0;
        for(int i=0;i<n;i++){
            currentNo = Math.max(latNo,lastHas+prices[i]);
            if(i>=2){
                currentHas = Math.max(lastHas,prveNo-prices[i]);
            } else {
                currentHas = Math.max(lastHas,-prices[i]);
            }
            prveNo = latNo;
            latNo = currentNo;
            lastHas = currentHas;
        }
        return currentNo;
    }



}
