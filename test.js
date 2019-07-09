/**
 * 数学的分拆数实验代码
 */

function splitNum(num) {
    let r = [];
    backtrace(num, 1, [], r);
    console.log(r.length);
}

function sum(array) {
    let sum = 0;
    array.forEach(element => {
        sum += element;
    });
    return sum;
}

function  backtrace(num, currentNum, current, result) {
    if (sum(current) == num) {
        result.push(1);
        return;
    }
    if (sum(current) > num) {
        return;
    }

    for(let i = currentNum; i <= num; i++) {
        current.push(i);
        backtrace(num, i, current, result);
        current.pop(i);
    }

}

splitNum(22)