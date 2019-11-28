/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:

输入: [3,1,5,8]
输出: 167 
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167


状态设计
dp[i, j]表示把[i, j]区间的所有气球捏爆的最大收益；

递推公式
假设[i, j]区间中最后一个捏爆的气球为k，则最后一次收益为nums[i-1] * nums[k] * nums[j+1]，于是遍历k得到递推公式：
dp[i, j] = max_k (dp[i, k-1] + dp[k+1, j] + nums[i-1] * nums[k] * nums[j+1])


 * @param {number[]} nums
 * @return {number}
 */
var maxCoins = function(nums) {
    return dp(nums);
};

var getNums = function(nums, index) {
    if (index < 0 || index >= nums.length) {
        return 1;
    } else {
        return nums[index];
    }
}


var dp = function(nums) {
    let dp = [];
    for(let i = 0; i < nums.length; i++) {
        dp[i] = [];
        dp[i][i] = getNums(nums,i) * getNums(nums,i-1) * getNums(nums, i+1) ;
    }
    for(let i = 1; i < nums.length; i++) { // 个数，从1个到2个到3个
        for(let j = 0; j < nums.length - i; j++) { // 下标，从0到最后
            let max = 0;
            let start = j;
            let end = j + i;
            for(let k = start; k <= end; k++) {
                max = Math.max((dp[start][k-1] || 0) + (dp[k+1] && dp[k+1][end] || 0) + getNums(nums, k) * getNums(nums, start - 1) * getNums(nums, end + 1), max);
            }
            dp[start][end] = max;
        }
    }
    return dp[0][nums.length-1];
}
// 3394
console.log(maxCoins([8,3,4,3,5,0,5,6,6,2,8,5,6,2,3,8,3,5,1,0,2]))
// console.log(maxCoins([3,1,5,8]))