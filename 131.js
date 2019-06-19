/**
 * 实现很丑陋，得优化下
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    let r = [];
    if (s.length === 1) {
        r.push([s]);
        return r;
    }
    backtrace(s, 1, [], r);
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


function transform(string, array) {
    let st = [];
    let index = 0;
    for (let i = 0; i < array.length; i++) {
        if (!st[index]) {
            st[index] = [];
        }
        if (!array[i]) {
            st[index] += (string.charAt(i));
            // st[index].push(string.charAt(i + 1));
        } else {
            st[index] += (string.charAt(i));
            index++;
        }
        if (i === array.length - 1) {
            if (!st[index]) {
                st[index] = [];
            }
            st[index] += (string.charAt(i + 1));
        }
    }
    return st;
}

function judge(st) {
    for(let i = 0; i < st.length;i++) {
        if (!isValid(st[i])) {
            return false;
        }
    }
    return true;
}


function backtrace(string, start, current, result) {
    // console.log(current);
    if (string.length - 1 === current.length) {
        let st = transform(string,current);
        if (judge(st)) {
            result.push(clone(st));
        }
        return;
    }
    if (current[current.length - 1]) {
        current.pop();
        let s = transform(string, current);
        current.push(true);
        if (!judge(s)) {
            return;
        }
    }
    current.push(true);
    backtrace(string, start + 1, current, result);
    current.pop();
    current.push(false);
    backtrace(string, start + 1, current, result);
    current.pop();
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


console.log(partition("seeslaveidemonstrateyetartsnomedievalsees"));