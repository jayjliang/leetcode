/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    let startArray = getStartPoint(board, word.charAt(0));
    return backtrace(board, word, 0, startArray, {});
};

function getStartPoint(board, char) {
    let r = [];
    for (let i = 0 ; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            if (board[i][j] === char) {
                r.push([i, j]);
            }
        }
    }
    return r;
}

function getmatchPoint(board, currentRow, currentCol, nextChar) {
    let r = [];
    if (isPositionValid(board, currentRow - 1, currentCol) && board[currentRow - 1][currentCol] === nextChar) {
        r.push([currentRow - 1, currentCol]);
    }
    if (isPositionValid(board, currentRow + 1, currentCol) && board[currentRow + 1][currentCol] === nextChar) {
        r.push([currentRow + 1, currentCol]);
    }
    if (isPositionValid(board, currentRow, currentCol - 1) && board[currentRow][currentCol - 1] === nextChar) {
        r.push([currentRow, currentCol - 1]);
    }
    if (isPositionValid(board, currentRow, currentCol + 1) && board[currentRow][currentCol + 1] === nextChar) {
        r.push([currentRow, currentCol + 1]);
    }
    return r;
}

function isPositionValid(board, row, col) {
    if (row >= 0 && row < board.length && col >= 0 && col < board[row].length) {
        return true;
    } else {
        return false;
    }
}

function backtrace(board, word, index, pointArray, visited) {
    // console.log(index, pointArray)
    if (index >= word.length) {
        return true;
    }
    if (pointArray.length < 0) {
        return false;
    }
    for (let i = 0; i < pointArray.length; i++) {
        let point = pointArray[i];
        let key = point[0] + '-' + point[1];
        if (!visited[key]) {
            visited[key] = true;
            let next = getmatchPoint(board, point[0], point[1], word.charAt(index + 1));
            if (backtrace(board, word, index + 1, next, visited)) {
                return true;
            };
            visited[key] = false;
        }
    }
    return false;
}

let board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
];
console.log(exist(board, "ABCCED"));
console.log(exist(board, "SEE"));
console.log(exist(board, "ABCB"));