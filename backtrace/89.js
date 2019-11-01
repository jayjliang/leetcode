/**
 * 说好的回溯结果变成了递归实现
 * 最可怕的是官方答案竟然是格雷码公式，之间背
 * @param {number} n
 * @return {number[]}
 */
var grayCode = function (n) {
    let r = solution(n);
    r.forEach((value, index) => {
        r[index] = number(value);
    })
    return r;
};


function clone(array) {
    let temp = [];
    array.forEach(element => {
        temp.push(element);
    });
    return temp;
}

function compare(left, right) {
    let flag = false;
    for(let i = 0; i < left.length;i++) {
        if (left[i] != right[i]) {
            if (flag) {
                return false;
            }
            flag = true;
        }
    }
    return true;
}

function number(array) {
    let sum = 0;
    for (let j = array.length - 1, i = 0;j>=0;j--,i++) {
        if (array[j] === 1) {
            sum += Math.pow(2, i);
        }
    }
    return sum;
}

function  solution(num) {
    if (num === 0) {
        return [0];
    }
    if (num === 1) {
        return [[0],[1]];
    }
    let r = []
    let last = solution(num - 1);
    for (let i = 0; i < last.length; i++) {
        last[i].unshift(0);
        r.push(clone(last[i]));
        last[i].shift();
    }
    for (let i = last.length - 1; i >= 0; i--) {
        last[i].unshift(1);
        r.push(clone(last[i]));
        last[i].shift();
    }
    return r;
}

function backtrace(current, target, index, result) {
    if (number(current) == 0) {
        return true;
    }
    result.push(clone(current));
    for (let j = n - 1; j >=0; j--) {

    }
    current.push(1)
    backtrace(current, target, index + 1, result);
    current.pop();
}

console.log(grayCode(3));