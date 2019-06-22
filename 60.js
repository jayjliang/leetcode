/**
 * 就是找规律递归计算
 * 比较麻烦的是递归的时候的下一轮数字的计算，因为实际上第一个数字是不算计数的
 * 例如3，2的时候，固定1的时候排列就只有2种
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getPermutation = function(n, k) {
    let r = [];
    solution(n,n, k, [], r);
    return r.join('');
};

const cache = {1:1, 2:2};
function factorial(num) {
    if (num < 1) {
        return num;
    }
    if (cache[num]) {
        return cache[num];
    }
    let result = num * factorial(num - 1);
    cache[num] = result;
    return result;
}

function solution(N, n, k, visited, result) {
    console.log(n, k, result)
    if (k === 0 || n === 1) {
        for (let i = 1, j = 1; i <=N; i++) {
            if (!visited[i]) {
                result.push(i);
            }
        }
        return;
    }
    let s = factorial(n - 1);
    let count = Math.ceil(k / s);
    console.log(s, count);
    for (let i = 1, j = 1; i <=N; i++) {
        if (!visited[i]) {
            if (j === count) {
                result.push(i);
                visited[i] = true;
            }
            j++;
        }
    }
    solution(N, n - 1, k - s * (count - 1), visited, result);
}

console.log(getPermutation(4,9));