/**
 * 解题思路：
 * 分数组个数是奇数还是偶数
 * 1. 偶数
 * 如果是偶数的话，实际上就是拆成两半分别计算，然后把结果岔开组合就好了
 * 2. 奇数
 * 如果是奇数的话，先算一半，再算剩下一半，但是需要注意的是，剩下的一半需要把最后一个元素提到第一个，然后再岔开组合就好了
 * 但是正确的解题思路是倒推
 */




/**
 * @param {number[]} deck
 * @return {number[]}
 */
var deckRevealedIncreasing = function(deck) {
    deck.sort(function(a, b) {
        return a < b ? -1 : 1;
    });
    // console.log(deck);
    return cal1(deck);
};

var cal = function(origin) {
    if (origin.length == 1) {
        return origin;
    }
    var result = [];
    var len = origin.length;
    if (len % 2 === 0) {
        // 个数为偶数
        var part2 = cal(origin.splice(len/2, len));
        for(var i = 0; i < len; i += 2) {
            result[i] = origin[i/2];
            result[i+1] = part2[i/2];
        }
    } else {
        // 个数为奇数
        var part2 = cal(origin.splice(len/2 + 1, len));
        result[0] = origin[0];
        result[1] = part2[part2.length - 1];
        for(var i = 2; i < len - 1; i += 2) {
            result[i] = origin[i/2];
            result[i+1] = part2[i/2 - 1];
        }
        result[i] = origin[i/2];
        
    }
    return result;
}

var cal1 = function (origin) {
    var result = [];
    for(var i = origin.length - 1; i >= 0; i--) {
        if (result.length > 0) {
            var temp = result.pop();
            result.unshift(temp);
            result.unshift(origin[i]);
        } else {
            result.push(origin[i]);
        }
    }
    return result;
}
console.log(deckRevealedIncreasing([17, 13, 11, 2, 3, 5, 7]))