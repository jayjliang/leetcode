var spiralOrder = function(matrix) {
    let row = matrix.length;
    if (row === 0) {
        return [];
    }
    let col = matrix[0].length;
    let result = [];
    for(let r = 0; r < row/2 && r < col/2; r++) {
        let endRow = row - r - 1;
        let endCol = col - r - 1;
        for(let i = r; i <= endCol; i++) {
            result.push(matrix[r][i]);
        }

        for(let i = r + 1; i <= endRow; i++) {
            result.push(matrix[i][col - 1 -r]);
        }

        if (r < endRow && r < endCol) {
            for(let i = endCol - 1; i >= r; i--) {
                result.push(matrix[row - 1 -r][i]);
            }
            for(let i = endRow - 1; i > r; i--) {
                result.push(matrix[i][r]);
            }
        }
    }
    return result;
}