package best_time_to_buy_and_sell_stock;

/**
 * Created by LiangJ on 2016/3/8.
 */
public class main {
    public static void  main(String[] args){
        Solution s = new Solution();
        int[] price ={1,4,2};
        System.out.println(s.maxProfit(price));
    }
};
class  Solution{
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1){
            return 0;
        }
        int max=0,curr=0;
        for(int i=1;i<prices.length;i++){
            curr =curr+prices[i]-prices[i-1];
            max = Math.max(max,curr);
            if(curr<0){
                curr =0;
            }
        }
        return max;
    }

    public int DpSolution(int[] prices){
        int n=prices.length;
        if(n<=1){
            return 0;
        }
        int profit = prices[1]-prices[0];
        int minPrices = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minPrices = Math.min(minPrices,prices[i]);
            profit = Math.max(profit,prices[i]-minPrices);
        }
        return profit;
    }
}
