/**
 * @param {string} digits
 * @return {string[]}
 */
const num2Strmap = {
    2: ['a', 'b', 'c'],
    3: ['d', 'e', 'f'],
    4: ['g', 'h', 'i'],
    5: ['j', 'k', 'l'],
    6: ['m', 'n', 'o'],
    7: ['p', 'q', 'r', 's'],
    8: ['t', 'u', 'v'],
    9: ['w', 'x', 'y', 'z'],
}

var letterCombinations = function(digits) {
    let r = [];
    backtrace(digits, 0, '', r);
    return r;
};

function backtrace(digits, index, current, result) {
    if (current.length === digits.length) {
        current.length > 0 && result.push(current);
        return;
    }

    let num = parseInt(digits.charAt(index));
    let allStr = num2Strmap[num]
    for(let i = 0; i < allStr.length;i++) {
        current+= allStr[i];
        backtrace(digits, index + 1, current, result);
        current = current.substring(0, index);
    }
}

console.log(letterCombinations('23'));