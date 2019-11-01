/**
 * 暴力求解，直接回溯，注意剪枝
 * 
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]

 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
    let r = [];
    backtrace(s, 0, [], r);
    return r;
};

function isVaildIpItem(item) {
    for(let i = 0; i < item.length; i++) {
        if (item.charAt(i) == '0' && item.length > 1) {
            return false;
        }
        if (item.charAt(i) != '0') {
            return true;
        }
    }
    return true;
}

function isValid(current, isFinal) {
    // console.log(current)
    if (isFinal) {
        if (current.length != 4) {
            return false;
        }
    } else {
        if (current.length > 4) {
            return false;
        }
    }
    
    for(let i = 0; i < current.length; i++) {
        if (parseInt(current[i]) > 255 || !isVaildIpItem(current[i])) {
            return false;
        }
    }
    return true;
}

function transform(s, current) {
    let r = [];
    let temp = '';
    for (let i = 0; i < current.length; i++) {
        if (current[i]) {
            temp += s.charAt(i);
            r.push(temp);
            temp = '';
        } else {
            temp += s.charAt(i);
        }
    }
    if (temp.length > 0) {
        r.push(temp);
    }
    return r;
}

function backtrace(s, index, current, result) {
    if (index >= s.length) {
        let strArr = transform(s, current);
        if (isValid(strArr, true)) {
            // console.log(strArr, current);
            result.push(strArr.join('.'));
        }
        return;
    }

    if (!isValid(transform(s, current))) {
        return;
    }
    if (index < s.length - 1) {
        current.push(true);
        backtrace(s, index + 1, current, result);
        current.pop();
    }
    current.push(false);
    backtrace(s, index + 1, current, result);
    current.pop();
}

console.log(restoreIpAddresses("010010"));