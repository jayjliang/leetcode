/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]


 * 两种回溯思路
 * backtrace的思想是：当前这个点是归左边还是右边，感觉很饶，不好想明白，也不推荐
 * backtrace1的思想是：先选一个a，然后后面再继续
 * 例如，
 * a => 继续回溯
 * ab => 继续回溯
 * abc => 继续回溯
 * abcd => 继续回溯
 * abcde => 继续回溯
 * 感觉非常非常像递归
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    let r = [];
    if (s.length === 1) {
        r.push([s]);
        return r;
    }
    backtrace1(s, 0, [], r);
    return r;
};

function isValid(array) {
    for(let i = 0; i < array.length / 2; i++) {
        if (array.charAt(i) !== array.charAt(array.length - 1 - i)) {
            return false;
        }
    }
    return true;
}

function judge(st) {
    for(let i = 0; i < st.length;i++) {
        if (!isValid(st[i])) {
            return false;
        }
    }
    return true;
}


function backtrace(string, start, currentResult, current, result) {
    // console.log(currentResult, current, start);
    if (start >= string.length) {
        // console.log(currentResult);
        if (current.length > 0) {
            currentResult.push(current.join(''));
            // console.log(currentResult);
        } else {
            if (judge(currentResult)) {
                result.push(clone(currentResult));
            }
            // console.log(currentResult);
        }
        return;
    }
    if (!judge(currentResult)) {
        return;
    }
    current.push(string.charAt(start));
    currentResult.push(current.join(''));
    backtrace(string, start + 1, currentResult, [], result);
    currentResult.pop();
    backtrace(string, start + 1, currentResult, current, result);
    current.pop();
    if (start === string.length - 1) {
        currentResult.pop();
    }
}

function clone(array) {
    let temp = [];
    array.forEach(element => {
        if (element instanceof Array) {
            temp.push(clone(element));
        } else {
            temp.push(element);
        }
    });
    return temp;
}

function backtrace1(string, index, current, result) {
    // console.log(current)
    if (index >= string.length) {
        if (judge(current)) {
            result.push(clone(current));
        }
        return;
    }
    for(let i = index; i < string.length;i++) {
        if (judge(current)) {
            current.push(string.substring(index, i + 1));
            backtrace1(string, i + 1, current, result);
            current.pop();
        }
    }

}


console.log(partition("abbab"));