/**
 * 回溯直接过，没毛病
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function (k, n) {
    let r = [];
    backtrace(n, k, [], 1, r);
    return r;
};

function clone(array) {
    let temp = [];
    array.forEach(element => {
        temp.push(element);
    });
    return temp;
}

function sum(array) {
    let sum = 0;
    array.forEach(element => {
        sum += element;
    });
    return sum;
}

function  backtrace(target, length, current, index, result) {
    // console.log(current)
    if (current.length === length) {
        if (sum(current) === target) {
            result.push(clone(current));
        }
        return;
    }
    for (let i = index; i < 10; i++) {
        current.push(i);
        backtrace(target, length, current, i + 1, result);
        current.pop();
    }
}
console.log(combinationSum3(3,9))