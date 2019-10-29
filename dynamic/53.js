/**
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 */

/**
 * @param {number[]} nums
 * @return {number}
 * dp[n] = Math.max(0, dp[n-1]) + nums[i]
 */
var maxSubArray = function (nums) {
    let res = nums[0];
    let dp = [nums[0]];
    
    let from = 0;
    let to = 0;
    for(let i = 1; i < nums.length; i++) {
        dp[i] = (Math.max(0, dp[i - 1]) + nums[i]);
        if (dp[i] > res) {
            if (dp[i - 1] < 0) {
                from = i;
            }
            to = i;
        }
        res = Math.max(dp[i], res);
    }

    let r = [];
    for(let i = from; i <= to; i++) {
        r.push(nums[i])
    }
    return r;
};



console.log(maxSubArray([5,3]));
// maxSubArray([1, -5, 4]);