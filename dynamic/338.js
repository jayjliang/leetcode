/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
 * @param {number} num
 * @return {number[]}
 */
var countBits = function (num) {
    if (num === 0) {
        return [0];
    }
    let r = [0];
    let c = 1;
    for (let i = 1; i <= num; i++) {
        if ((i&(i-1)) === 0) {
            c = c * 2;
            r[i] = 1;
        } else {
            let n = i - c/2;
            r[i] = r[c/2] + r[n];
        }
    }
    return r;
};
console.log(countBits(16));