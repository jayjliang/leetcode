/**
 * 回溯算法解决
 * 题目的数组实际上是不管顺序的，那就直接增序就好了
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    let r = [];
    dfs(n, k, [], 1, r, []);
    return r;
};

function clone(array) {
    let temp = [];
    array.forEach(element => {
        temp.push(element);
    });
    return temp;
}

function dfs(origin, target, current, index, result, visited) {
    if (current.length == target) {
        return result.push(clone(current));
    }
    for(let i = index; i <= origin; i++) {
        if (!visited[i]) {
            current.push(i);
            visited[i] = true;
            dfs(origin, target, current, i, result, visited);
            current.pop(i);
            visited[i] = false;
        }
    }
}

console.log(combine(4,2));