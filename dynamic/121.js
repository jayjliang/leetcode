/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(k,prices) {
    if (prices.length === 0) {
        return 0;
    }
    let maxCount = k;
    let len = prices.length;
    let dp = [];
    for(let j = 0; j <= (len+1)/2 + 1; j++) {
        dp[j] = [];
    }
    for(let i = 0; i <= (len+1)/2 + 1; i++) {
        dp[i][0] = 0;
        dp[i][1] = 0;
    }
    dp[0][1] = -prices[0];
   
    for(let i = 1; i < len; i++) {
        for(let j = 0; j <= maxCount && j <= (i+1)/2; j++) {
            if (j >= 1 && isValid(i-1, j-1 ,1)) {
                dp[j][0] = Math.max(dp[j][0] || 0, (dp[j-1][1] || 0) + prices[i]);
            } else {
                dp[j][0] = (dp[j][0] || 0);
            }
            if (isValid(i-1, j, 1)) {
                dp[j][1] = Math.max((dp[j][1] || 0), (dp[j][0] || 0) - prices[i]);
            } else {
                dp[j][1] = (dp[j][0] || 0) - prices[i]
            }
        }
    }
    // console.log(dp)
    let max = 0;
    for(let i = 0; i <= (len+1)/2 + 1; i++) {
        max = Math.max(dp[i][0] || 0, max)
    }
    return max
};

function isValid(day, count, status) {
    return count * 2 + status <= day + 1;
}

console.log(maxProfit(2, [3,2,6,5,0,3]));