/**
 * 解题思路：
 * 在46的基础上，首先要排序，因为不排序的话缓存的key可能导致不一样，例如330和303，实际上都是一样的
 * 缓存只能每次遍历的时候有一个，因为实际上不需要处理的也就是每次遍历的时候，如果取到的数字是一样的，剩下也是一样的，那就不需要再算了
 * @param {number[]} nums
 * @return {number[][]}
 */

var permuteUnique = function (nums) {
    nums = sort(nums);
    return cal(nums, {});
};

var splice = function(nums, start, end) {
    let result = [];
    for(let i = 0; i < start; i++) {
        result.push(nums[i]);
    }
    for(let i = end; i < nums.length; i++) {
        result.push(nums[i]);
    }
    return result;
}

function sort(array) {
    array.sort(function (a, b) {
        return a < b ? -1 : 1;
    });
    return array;
}

var cal = function (nums, cache) {
    // console.log(nums);
    if (nums.length === 1) {
        return [nums];
    }
    const result = [];
    for(let i = 0; i < nums.length; i++) {
        let newNums = splice(nums, i, i + 1);
        let key = `${nums[i]}-${newNums.join(',')}`;
        if (cache[key]) {
            // return result;
        } else {
            cache[key] = true;
            let pre = cal(newNums, {});
            pre.forEach(element => {
                element.unshift(nums[i]);
                result.push(element);
            });
        }
    }
    return result;
}
console.log(cal([3,3,3,0], {}))
// console.log(cache);