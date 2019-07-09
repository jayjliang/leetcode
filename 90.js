/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function (nums) {
    nums = sort(nums);
    let r = [];
    backtrace(nums, 0, [], r);
    return r;
};

function sort(array) {
    array.sort(function (a, b) {
        return a < b ? -1 : 1;
    });
    return array;
}

function clone(array) {
    let temp = [];
    array.forEach(element => {
        if (element instanceof Array) {
            temp.push(clone(element));
        } else {
            temp.push(element);
        }
    });
    return temp;
}


function backtrace(nums, index, current, result) {
    if (index > nums.length) {
        return;
    }
    result.push(clone(current));
    for (let i = index; i < nums.length; i++) {
        // 这个条件是核心，我只选连续出现中的一个，和40题可以对比下
        if (i > index && nums[i] == nums[i-1]) {
            continue;
        }
        current.push(nums[i]);
        backtrace(nums, i + 1, current, result);
        current.pop(nums[i]);
    }
}

console.log(subsetsWithDup([1, 2, 2, 2]));