package best_time_to_buy_and_sell_stock_iii;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by LiangJ on 2016/3/21.
 */
public class main {
    public static void  main(String[] args){
        Solution s = new Solution();
        int[] price ={1,2,4};
        System.out.println(s.maxProfit(price));

    }
};
class  Solution{
    /*
    思路：
        利用动态规划记录好每一个点的正序和逆序最大值
        然后对每一个点，求正序和逆序最大值和
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1){
            return 0;
        }
        if(n<=2){
            return Math.max(prices[1]-prices[0],0);
        }
        int[] dp = new int[n];
        int[] rdp = new int[n];
        int curr=0,max=0;
        for(int i=1;i<n;i++){
            curr =curr+prices[i]-prices[i-1];
            max = Math.max(max,curr);
            if(curr<0){
                curr =0;
            }
            dp[i] = max;
        }
        curr = 0;
        max=0;
        for(int j=n-1;j>0;j--){
            curr = curr+prices[j]-prices[j-1];
            max = Math.max(max,curr);
            if(curr<0){
                curr =0;
            }
            rdp[j] = max;
        }
        max= 0;
        for(int k=0;k<n;k++) {
            System.out.println(dp[k] + " " + rdp[k]);
        }
        for(int k=1;k<n-1;k++){
            System.out.println(dp[k]+" "+rdp[k]);
            max = Math.max(max,dp[k-1]+rdp[k+1]);
        }
        return max;
    }

    public int dpSolution(int[] prices){
        // these four variables represent your profit after executing corresponding transaction
        // in the beginning, your profit is 0.
        // when you buy a stock ,the profit will be deducted of the price of stock.
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) firstBuy = -curPrice; // the max profit after you buy first stock
            if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice; // the max profit after you sell it
            if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice; // the max profit after you buy the second stock
            if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice; // the max profit after you sell the second stock
        }

        return secondSell; // secondSell will be the max profit after passing the prices
    }
}
