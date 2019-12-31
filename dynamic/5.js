/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    if (!s) {
        return '';
    }
    let len = s.length;
    let dp = [];
    for(let i = 0; i < len; i++) {
        dp[i] = [];
    }
    let realStart = 0;
    let realEnd = 0;
    // i表示长度
    for(let i = 2; i <= len; i++) {
        // j表示起始下标
        for(let j = 0; j <= len - i; j++) {
            dp[j][j] = 1;
            let end = i+j-1;
            if (end > 0) {
                if (s.charAt(j) === s.charAt(i+j-1)) {
                    if (i === 2) {
                        dp[j][end] = true;
                    } else {
                        dp[j][end] = dp[j+1][end-1];
                    }
                    if (dp[j][end] && i > (realEnd - realStart)) {
                        realStart = j;
                        realEnd = end;
                    }
                } else {
                    dp[j][end] = 0;
                }
            }
            
        }
    }
    console.log(dp);
    return s.slice(realStart, realEnd + 1);
};

console.log(longestPalindrome("bb"))