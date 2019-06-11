/**
 * 解题思路：
 * 递归就好了，[1,2,3]是在[2,3]的基础上再加上1就ok了
 * 
 * 回溯也可以
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
    // return cal(nums);

    let result = [];
    dfs(nums, result, [], []);
    return result;
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

var cal = function (nums) {
    // console.log(nums);
    if (nums.length === 1) {
        return [nums];
    }
    const result = [];
    for(let i = 0; i < nums.length; i++) {
        let newNums = splice(nums, i, i + 1);
        let pre = cal(newNums);
        pre.forEach(element => {
            element.unshift(nums[i]);
            result.push(element);
        });
    }
    return result;
}

var clone = function array(params) {
    let r = [];
    params.forEach(ele => {
        r.push(ele);
    });
    return r;
}

function dfs(str, result, current, visited) {
    if (current.length === str.length) {
        result.push(clone(current));
    }
    for (let i = 0; i < str.length; i++) {
        var input = str[i];
        if (!visited[i]) {
            visited[i] = true;
            current.push(input);
            dfs(str, result, current, visited);
            current.pop();
            visited[i] = false;
        }
    }
}

console.log(cal([1,2,3]))