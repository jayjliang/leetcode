/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param {number[][]} grid
 * @return {number}
 * dp[i][j] = Math.min(dp[i-1][j] + dp[i][j], dp[i][j-1]+dp[i][j])
 */
var minPathSum = function (grid) {
    let m = grid.length;
    let n = grid[0].length;
    let dp = [];
    for(let i = 0; i < m; i++) {
        dp[i] = [];
    }
    dp[0][0] = grid[0][0];
    for (let i = 0; i < m; i++) {
        for(let j = 0; j < n; j++) {
            if (i >= 1 && j >=1) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j])
            } else if (i >= 1 && j === 0) {
                dp[i][j] = dp[i - 1][j] + grid[i][j];
            } else if (i === 0 && j >= 1) {
                dp[i][j] = dp[i][j - 1] + grid[i][j];
            }
        }
    }
    return dp[m-1][n-1];
};
console.log(minPathSum([
    [1, 3, 1],
    [1, 5, 1],
    [4, 2, 1]
]))