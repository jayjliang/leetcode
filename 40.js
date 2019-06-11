/**
 * 回溯解决，没啥问题
 * 主要是先将数组排序
 * 然后需要有一个递增操作，原因是为了避免出现2，3和3，2这种重复
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    let r = [];
    candidates = sort(candidates);
    backtrace(candidates, target, [], 0, [], r, {});
    return r;
};


function clone(array) {
    let temp = [];
    array.forEach(element => {
        temp.push(element);
    });
    return temp;
}

function sort(array) {
    array.sort(function(a, b) {
        return a < b ? -1 : 1;
    });
    return array;
}

function sum(array) {
    let sum = 0;
    array.forEach(element => {
        sum += element;
    });
    return sum;
}

function backtrace(candidates, target, current, index, visited, result, cache) {
    // console.log(current, sum(current), target);
    if (sum(current) >= target) {
        if (sum(current) == target && !cache[current.join()]) {
            cache[current.join()] = true;
            result.push(clone(current));
        }
        return;
    }
    console.log(current);
    for (let i = index; i < candidates.length; i++) {
        if (i != index && candidates[i] == candidates[index]) {
            continue;
        }
        current.push(candidates[i]);
        backtrace(candidates, target, current, i + 1, visited, result, cache);
        current.pop();
    }
}
console.log(combinationSum2([10,1,2,7,6,1,5], 8))