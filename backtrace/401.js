/**
 * 回溯算法解决，只是需要分小时和分钟处理
 * @param {number} num
 * @return {string[]}
 */
var readBinaryWatch = function (num) {
    let result = [];
    for (let i = 0; i <= 4 && i <= num; i++) {
        let allHour = getAllHour(i);
        let allMin = getAllMin(num - i);
        // console.log(allHour)
        // console.log(allHour);
        for(let m = 0; m < allHour.length; m++) {
            for(let n = 0; n < allMin.length; n++) {
                let hour = calNumber(allHour[m]);
                let min = calNumber(allMin[n]);
                if (hour < 12 && min < 60) {
                    result.push(formatHour(hour) + ':' + formatMin(min))
                }
            }
        }
    }
    return result;
};

function calNumber(array) {
    let r = 0;
    array.forEach((ele, index) => {
        if (ele) {
            r += (1 << (index));
        }
    });
    return r;
}

function formatHour(num) {
    return num;
}

function getAllHour(num) {
    let r = [];
    dfs(4, num, r, [], 0);
    return r;
}

function getAllMin(num) {
    let r = [];
    dfs(6, num, r, [], 0);
    return r;
}

function formatMin(num) {
    if (num === 0) {
        return '00';
    }
    if (num < 10) {
        return '0' + num;
    }
    return num;
}

function clone(params) {
    let r = [];
    params.forEach(ele => {
        r.push(ele);
    });
    return r;
}

function  oneBit(array) {
    let r = 0;
    array.forEach((ele) => {
        if (ele) {
            r++;
        }
    });
    return r;
}

function dfs(all, target, result, current, index) {
    // console.log(current);

    if (oneBit(current) === target && current.length == all) {
        result.push(clone(current));
        return;
    }
    for (let i = index; i < all; i++) {
        current.push(0);
        if (oneBit(current) <= target) {
            dfs(all, target, result, current, i + 1);
        }
        current.pop();
        current.push(1);
        if (oneBit(current) <= target) {
            dfs(all, target, result, current, i + 1);
        }
        current.pop();
    }
}

console.log(readBinaryWatch(2));