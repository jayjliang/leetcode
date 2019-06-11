/**
 * 直接回溯解决，好像没有什么问题
 * 注意终止条件就好，使用stack的方式验证是否合理
 * 中间不减枝也可以过，如果要减的化，感觉应该是左边要恒大于右边
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    let r = [];
    dfs(n, [], r);
    return r;
};

function clone(array) {
    let temp = [];
    array.forEach(element => {
        temp.push(element);
    });
    return temp;
}

function isValid(array) {
    let left = [];
    let right = [];
    for(let i = 0; i < array.length; i++) {
        if (array[i] == '(') {
            left.push('(');
        }
        if (array[i] == ')') {
            if (left.length < 1) {
                return false;
            }
            left.pop();
        }
    }
    if (left.length == 0 && right.length == 0) {
        return true;
    } else {
        return false;
    }
}

function cut(array) {
    let left = 0;
    let right = 0;
    for(let i = 0; i < array.length; i++) {
        if (array[i] == '(') {
            left++;
        }
        if (array[i] == ')') {
            right++
        }
        if (left < right) {
            return false;
        }
    }
    return left <right;
}

function dfs(target, currentArray, result) {
    if (currentArray.length >= target * 2) {
        if (isValid(currentArray)) {
            result.push(currentArray.join(""));
        }
        return;
    }
    if (cut(currentArray)) {
        return;
    }
    // console.log(currentArray)
    currentArray.push('(');
    dfs(target, currentArray, result);
    currentArray.pop();
    currentArray.push(')');
    dfs(target, currentArray, result);
    currentArray.pop();
}

console.log(generateParenthesis(3));