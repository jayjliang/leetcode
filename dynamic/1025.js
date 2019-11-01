/**
 * @param {number} N
 * @return {boolean}
 */
var divisorGame = function (N) {
    if (N === 1) {
        return false;
    }
    let dp = [false];
    for (let i = 2; i <= N; i++) {
        let flag = false;
        for ( let j = 1; j < i; j++) {
            if (i % j === 0) {
                if (!dp[i - j]) {
                    flag = true;
                    break;
                }
            }
        }
        dp[i] = flag;
    }
    return dp[N];
};
console.log(divisorGame(3))