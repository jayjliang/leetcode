/**
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：

i - K <= r <= i + K, j - K <= c <= j + K
(r, c) 在矩阵内。


示例 1：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
输出：[[12,21,16],[27,45,33],[24,39,28]]
示例 2：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
输出：[[45,45,45],[45,45,45],[45,45,45]]
🇬应该是类似一维数组的前缀和一样，求二维数组的前缀和

 * @param {number[][]} mat
 * @param {number} K
 * @return {number[][]}
 */
var matrixBlockSum = function (mat, K) {
    let row = mat.length;
    if (row < 1) {
        return [];
    }
    let col = mat[0].length;
    let result = [];
    let rowSum = [];
    for (let i = 0; i < row; i++) {
        result[i] = [];
        rowSum[i] = [];
        for(let j = 0; j< col; j++) {
            rowSum[i][j] = (rowSum[i][j-1] || 0) + mat[i][j]
        }
    }

    for (let i = 0; i < row; i++) {
        for(let j = 0; j < col; j++) {
            let rowStart = Math.max(0, i- K);
            let rowEnd = Math.min(row-1, i + K);
            let colStart = Math.max(0, j - K);
            let colEnd = Math.min(col - 1, j + K);
            let sum = 0;
            for(let s = rowStart; s <= rowEnd; s++) {
                sum += rowSum[s][colEnd] - rowSum[s][colStart] + mat[s][colStart];
            }
            result[i][j] = sum;
        }
    }

    return result;
};

function getRangeSum(mat,rowS, rowE, colS, colE) {
    console.log(rowS, rowE, colS, colE)
    let sum = 0;
    for(let i = rowS; i <= rowE; i++) {
        for(let j = colS; j<= colE; j++) {
            sum += mat[i][j];
        }
    }
    return sum;
}
let mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]], K = 1;
console.log(matrixBlockSum(mat, K));
