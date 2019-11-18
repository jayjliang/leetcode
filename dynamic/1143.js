/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。

 

示例 1:

输入：text1 = "abcde", text2 = "ace" 
输出：3  
解释：最长公共子序列是 "ace"，它的长度为 3。
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