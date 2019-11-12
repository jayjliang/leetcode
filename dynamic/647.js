/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".
示例 2:

输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindromic-substrings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param {string} s
 * @return {number}
 * 这里现在的思路想叉了。
 * dp[i][j]表示的应该就是i到j这个字符串是否回文，而不是回文的个数，个数最后计算再加
 */
var countSubstrings = function(s) {
    let len = s.length;
    let dp = [];
    for(let i = 0; i < len; i++) {
        dp[i] = [];
    }
    for(let i = len - 1; i >= 0;i--) {
        for (let j = i; j < len; j++) {
            if (i===j) {
                dp[i][j] = 1;
                continue;
            }
            dp[i][j] = 0;
            if (i < len - 1) {
                dp[i][j] += dp[i+1][j]
            }
            if (j >= 1) {
                dp[i][j] += dp[i][j-1];
            }
            if (i < len - 1 && j >= 1 && i+1<=j-1) {
                dp[i][j] -= dp[i+1][j-1];
            }
            if (judge(s, i, j)) {
                dp[i][j] += 1;
            }
        }
    }
    return dp[0][len-1];
};

function judge(str, start, end) {
    for (let i = start; i <= end;i++) {
        if (str.charAt(i) != str.charAt(end-(i-start))) {
            return false;
        }
    }
    return true;
}
console.log(countSubstrings('aaaaa'));