/**
 * 就是很多条件会比较复杂，其实原理还是回溯
 * 这里有一点比较特别的是，当一行计算完成后，需要计算下一行
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function(board) {
    let r = [];
    backtrace(board, 0, 0, r);
};

function isComplete(board) {
    let row = board.length;
    let col = board[0].length;
    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            if (board[i][j] === '.') {
                return false;
            }
        }
    }
    return true;
}

function isRowComplete(board, row) {
    let col = board[0].length;
    for (let j = 0; j < col; j++) {
        if (board[row][j] === '.') {
            return false;
        }
    }
    return true;
}

function isValid(board) {
    let row = board.length;
    let col = board[0].length;
    for (let i = 0; i < row; i++) {
        let cache = {};
        for (let j = 0; j < col; j++) {
            if (cache[board[i][j]]) {
                return false;
            }
            if (board[i][j] != '.') {
                cache[board[i][j]] = true;

            }
        }
    }

    for (let i = 0; i < col; i++) {
        let cache = {};
        for (let j = 0; j < row; j++) {
            if (cache[board[j][i]]) {
                return false;
            }
            if (board[j][i] != '.') {
                cache[board[j][i]] = true;
            }
            
        }
    }

    for (let i = 0; i < row; i += row/3) {
        for (let j = 0; j < col; j+= col/3) {
            let cache = {};
            for (let m = 0; m < row/3; m++) {
                for (let n = 0; n < col/3; n++) {
                    if (cache[board[i+m][j+n]]) {
                        return false;
                    }
                    if (board[i+m][j+n] != '.') {
                        cache[board[i+m][j+n]] = true;
                    }
                }
            }
            
        }
    }
    return true;
}

function getAvaliableInRow(board, index) {
    let col = board[0].length;
    let cache = {};
    for (let i = 0; i < col; i++) {
        cache[board[index][i]] = true;
    }
    let result = [];
    for (let i = 1; i <= col; i++) {
        if (!cache[i]) {
            result.push(i + '');
        }
    }
    return result;
}


function getAvaliableInCol(board, index) {
    let row = board.length;
    let cache = {};
    for (let i = 0; i < row; i++) {
        cache[board[row][index]] = true;
    }
    let result = [];
    for (let i = 0; i < row; i++) {
        if (!cache[i]) {
            result.push(i);
        }
    }
    return result;
}

function fillNextInRow(board, index, num) {
    let col = board[0].length;
    for (let i = 0; i < col; i++) {
        if (board[index][i] == '.') {
            board[index][i] = num;
            return i;
        }
    }
    return -1;
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

function backtrace(current, rowIndex, colIndex, result) {
    // console.log(current);
    if (!isValid(current)) {
        return false;
    }
    if (isComplete(current)) {
        result.push(clone(current));
        // console.log(current);
        return true;
    }

    let ava = getAvaliableInRow(current, rowIndex);
    if (ava.length > 0) {
    } else {
        ava = getAvaliableInRow(current, rowIndex + 1);
        rowIndex += 1;
    }
    for(let i = 0; i < ava.length; i++) {
        let index  = fillNextInRow(current, rowIndex, ava[i]);
        if (backtrace(current, rowIndex, colIndex + 1, result)) {
            return true;
        }
        current[rowIndex][index] = '.';
    }
    
    
}

const testCase = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]];
solveSudoku(testCase);