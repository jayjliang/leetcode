/**
 * 找规律的题目，和动态规划没有半毛钱关系
 * @param {number} n
 * @param {number} k
 * @return {number[]}
 */
var constructArray = function(n, k) {
    return solution(n,k);
};

function solution(n, k) {
    let start = n - k;
    let r = [];
    for (let i = 1; i <= start; i++) {
        r[i-1] = i;
    };
    let half = Math.ceil(k/2);
    for(let i = start + 1, j = start + 2; i <= n - half ; i++, j+= 2) {
        // console.log(j, i);
        r[j - 1] = i;
    }
    for (let i = n, j = start + 1; i > n - half; i--, j+= 2) {
        // console.log(j, i);
        r[j - 1] = i;
    }
    return r;
}
console.log(constructArray(9999,9998).length)