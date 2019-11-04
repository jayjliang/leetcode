/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function (text1, text2) {
    let m = text1.length;
    let n = text2.length;
    let dp = [];
    for (let i = 0; i <= m; i++) {
        dp[i] = [];
        
    }
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (text1.charAt(i-1) === text2.charAt(j-1)) {
                dp[i][j] = (dp[i-1][j-1] || 0) + 1;
            } else {
                dp[i][j] = Math.max(dp[i-1][j] || 0, dp[i][j-1] || 0);
            }
        }
    }
    return dp[m][n];
};
console.log(longestCommonSubsequence("abcde", "ace"))