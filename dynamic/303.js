/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

示例：

给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
说明:

你可以假设数组不可变。
会多次调用 sumRange 方法。

 */

/**
 * @param {number[]} nums
 */
var NumArray = function(nums) {
    this.cache = [];
    this.nums = nums;
    this.initRangeValue();
};

/** 
 * @param {number} i 
 * @param {number} j
 * @return {number}
 */
NumArray.prototype.sumRange = function(i, j) {
    return this.cache[j] - (this.cache[i-1] || 0);
};

NumArray.prototype.initRangeValue = function() {
    this.cache[0] = this.nums[0];
    for(let i = 1; i < this.nums.length; i++) {
        this.cache[i] = this.cache[i-1] + this.nums[i];
    }
}

var obj = new NumArray([-2, 0, 3, -5, 2, -1])
console.log(obj.sumRange(0,2))
console.log(obj.sumRange(2,5))
console.log(obj.sumRange(0,5))

/** 
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */