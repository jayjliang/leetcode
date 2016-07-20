package best_time_to_buy_and_sell_stock_II;

/**
 * Created by LiangJ on 2016/3/8.
 */
public class main {
    public static void  main(String[] args){
        Solution s = new Solution();
        int[] price ={1,2,3,0,3,6,9,8,18};
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
            max =Math.max(max,max+prices[i]-prices[i-1]);
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

