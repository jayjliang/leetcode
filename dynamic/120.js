/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
    let m = triangle.length;
    for (let i = 0; i < m; i++) {
        for(let j = 0; j <= i; j++) {
            if (i >= 1 && j < i && j >=1) {
                triangle[i][j] = Math.min(triangle[i-1][j-1], triangle[i - 1][j]) + triangle[i][j];
            } else if ( i >= 1 && i === j && j >= 1) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
            } else if ( i >=1 && j === 0) {
                triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
            }
        }
    }
    return minArray(triangle[m-1]);
}

var minArray = function (array) {
    let min = Infinity;
    array.forEach(element => {
        min = Math.min(element, min);
    });
    return min;
}
