/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。

一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。

给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。

说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

示例 1:

输入: "112358"
输出: true 
解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

 * 回溯解决，类似回文字符串
 * 但是额外注意的就是一个数字不能以0开头，但是只有一个0是可以的
 * @param {string} num
 * @return {boolean}
 */
var isAdditiveNumber = function(num) {
    return backtrace(num, 0 , []);
};

function isValid(current, end) {
    // console.log(current, end);
    for (let i = 2; i < (end || current.length); i++) {
        if (current[i] != current[i-1] + current[i-2]) {
            return false;
        }
    }
    return true;
}

function getSum(num, start, end) {
    return parseInt(num.substring(start, end + 1));
}
function backtrace(num, index, current) {
    // console.log(index, current)
    if (index >= num.length) {
        if (isValid(current) && current.length >= 3) {
            console.log(current)
            return true;
        }
        return false;
    }

    if (!isValid(current, current.length - 1)) {
        return false;
    }

    // if (num.charAt(index) === '0') {
    //     return false;
    // }
    
    for (let i = index ; i < num.length; i++) {
        if (num.charAt(index) === '0' && i > index) {
            return false;
        }
        sum = getSum(num, index, i);
        current.push(sum);
        // current[sumIndex] = temp1 * 10 + parseInt(num.charAt(i));
        // console.log(index, current[index]);
        if(backtrace(num, i + 1, current)) {
            return true;
        };
        current.pop();
        // current[index] = temp;
    }
    return false;
}

console.log(isAdditiveNumber("112358"));