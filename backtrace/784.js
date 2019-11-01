/**
 * @param {string} S
 * @return {string[]}
 */
var letterCasePermutation = function (S) {
    let result = [];
    dfs(S, result, [], 0);
    return result;
};

function  isNumber(input) {
    return input >= 0 && input <= 9;
}

function  changeCase(input) {
    if (input.toUpperCase() !== input) {
        return input.toUpperCase();
    } else {
        return input.toLowerCase();
    }
}

function  dfs(str, result, current, index) {
    if (current.length === str.length) {
        result.push(current.join(''));
    }
    // console.log(current);
    for (let i = index; i < str.length; i++) {
        var input = str.charAt(i);
        if (isNumber(input)) {
            current.push(input);
            dfs(str, result, current, i + 1);
            current.pop();
        } else {
            current.push(input);
            dfs(str, result, current, i + 1);
            current.pop();
            current.push(changeCase(input));
            dfs(str, result, current, i + 1);
            current.pop();
        }
    }
}

console.log(letterCasePermutation("C"))