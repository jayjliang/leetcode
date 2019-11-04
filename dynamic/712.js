/**
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。

示例 1:

输入: s1 = "sea", s2 = "eat"
输出: 231
解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
在 "eat" 中删除 "t" 并将 116 加入总和。
结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。

 * 
 * @param {string} s1
 * @param {string} s2
 * @return {number}
 */
var minimumDeleteSum = function(s1, s2) {
    let m = s1.length;
    let n = s2.length;
    let dp = [];
    for ( let i = 0; i <= m; i++) {
        dp[i] = [];
    }
    for (let i = m - 1; i >= 0; i--){
        dp[i][n] = (dp[i+1][n] || 0) + s1.charCodeAt(i);
    }
    for (let i = n - 1; i >= 0; i--) {
        dp[m][i] = (dp[m][i + 1] || 0) + s2.charCodeAt(i);
    }
    for (let i = m-1; i >= 0; i--) {
        for(let j = n-1; j >= 0; j--) {
            if (s1[i] === s2[j]) {
                dp[i][j] = dp[i+1][j+1] || 0;
            } else {
                dp[i][j] = Math.min(dp[i+1][j] + s1.charCodeAt(i), dp[i][j+1] + s2.charCodeAt(j));
            }
        }
    }
    return dp[0][0];
};

console.log(minimumDeleteSum("bbccacacaab","aabccb"))