/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if (prices.length === 0) {
        return 0;
    }
    let len = prices.length;
    let dp = [];
    for(let i = 0;i < len ;i++) {
        dp[i] = [];
    }
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for(let i = 1; i < len; i++) {
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
    }
    return Math.max(dp[len-1][0], dp[len-1][1]);
};
console.log(maxProfit([7,1,5,3,6,4]));