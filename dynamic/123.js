var maxProfit = function(prices) {
    if (prices.length === 0) {
        return 0;
    }
    let maxCount = 2;
    let len = prices.length;
    let dp = [];
    for(let i = 0;i < len ;i++) {
        dp[i] = [];
        for(let j = 0; j <= maxCount; j++) {
            dp[i][j] = [];
        }
    }
    for(let i = 0; i <= maxCount; i++) {
        dp[0][i][0] = 0;
        dp[0][i][1] = 0;
    }
    dp[0][0][1] = -prices[0];
   
    for(let i = 1; i < len; i++) {
        for(let j = 0; j <= maxCount && j <= (i+1)/2; j++) {
            if (j >= 1 && isValid(i-1, j-1 ,1)) {
                dp[i][j][0] = Math.max(dp[i-1][j][0] || 0, (dp[i-1][j-1][1] || 0) + prices[i]);
            } else {
                dp[i][j][0] = (dp[i-1][j][0] || 0);
            }
            if (isValid(i-1, j, 1)) {
                dp[i][j][1] = Math.max((dp[i-1][j][1] || 0), (dp[i-1][j][0] || 0) - prices[i]);
            } else {
                dp[i][j][1] = (dp[i-1][j][0] || 0) - prices[i]
            }
        }
    }
    // console.log(dp)
    let max = 0;
    for(let i = 0; i <= maxCount; i++) {
        max = Math.max(dp[len - 1][i][0] || 0, max)
    }
    return max
};

function isValid(day, count, status) {
    return count * 2 + status <= day + 1;
}