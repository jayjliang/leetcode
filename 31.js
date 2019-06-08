/**
 * 解题思路：
 * 1. 先找到应该交换的数字，这里需要注意的是一定要找到最小交互的数字，也就是改变最右边的那个数字，因为有可能从后往前算的时候，虽然可以交换，但是不一定是最右边的
 * 2. 交换后右边的数字需要进行调整，来获取最小，有点类似进位了，后面要找到最小的排列
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    let origin = nums.join(',');
    
    let left = -1;
    let right = -1;
    for(let i = nums.length - 1; i >= 1;i--) {
        for (let j = i - 1; j >= 0; j--) {
            if (nums[i] > nums[j]) {
                if (j > left) {
                    left = j;
                    right = i;
                }
            }
        }
    }

    if (left > -1) {
        changeNums(nums, left, right);
        for(let i = nums.length - 1; i > left;i--) {
            for (let j = i - 1; j > left; j--) {
                if (nums[i] < nums[j]) {
                    changeNums(nums, i, j);
                }
            }
        }
    }
    
    if (left > -1) {
        console.log(origin, '->',nums.join(','));
    } else {
        console.log(origin, '->',sort(nums).join(','));
    }
};

function changeNums(array, i, j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

function sort(array) {
    array.sort(function(a, b) {
        return a < b ? -1 : 1;
    });
    return array;
}

nextPermutation([4,2,0,2,3,2,0])