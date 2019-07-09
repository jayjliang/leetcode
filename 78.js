/**
 * 解题思路
 * 从前往后，每增加一个元素，就是把之前的组合加上新元素组成新组合
 * 例如[1,2]的时候现在是[[],[1],[2],[1,2]]
 * 现在加了一个3，那就把之前组合保持不变，再把每个元素加上3，组成新组合
 * [[],[1],[2],[1,2], [3],[1,3],[2,3],[1,2,3]]
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(array) {
    let r = [];
    backtrace(array, 0, [], r);
    return r;
};

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

function recurse(array) {
    if (array.length < 1) {
        return [];
    }
    var result = [[], [array[0]]];
    for (var i = 1; i < array.length; i++) {
        var temp = clone(result);
        temp.forEach(ele => {
            ele.push(array[i]);
        });
        result = result.concat(temp);
    }

    return result;
}

function backtrace(nums, index, current, result) {
    // console.log(current, index, nums.length);

    if (index > nums.length) {
        return;
    }
    result.push(clone(current));
    for(let i = index; i < nums.length;i++) {
        current.push(nums[i]);
        backtrace(nums, i + 1, current, result);
        current.pop(nums[i]);
    }
}

console.log(subsets([1,2,3]));