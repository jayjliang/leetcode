/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number} n
 * @return {TreeNode[]}
 */
function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

var generateTrees = function(n) {
    let array = [];
    for(let i = 0;i < n;i++) {
        array.push(i+1);
    }
    let result = generateTreesWithNum(cutArray(array, 0 ,n-1));
    return result;
};

var cutArray = function(array, start, end) {
    let r = [];
    for(let i = start; i <= end; i++) {
        r.push(array[i]);
    }
    return r;
}

function generateTreesWithNum(arrays) {
    let num = arrays.length
    if (num === 1) {
        return [new TreeNode(arrays[0])];
    }
    if ( num=== 2) {
        let left = new TreeNode(arrays[1]);
        left.left = new TreeNode(arrays[0]);
        let right = new TreeNode(arrays[0]);
        right.right = new TreeNode(arrays[1]);
        return [left, right]
    }
    
    let r = [];
    for(let j = 0; j < num; j++) {
        let left = cutArray(arrays, 0, j-1);
        let right = cutArray(arrays, j+1, num-1);
        if (left.length === 0) {
            let rightArray = generateTreesWithNum(right);
            rightArray.forEach(element => {
                let node  = new TreeNode(arrays[j]);
                node.right = element;
                r.push(node);
            });
        } else if (right.length === 0) {
            let leftArray = generateTreesWithNum(left);
            leftArray.forEach(element => {
                let node  = new TreeNode(arrays[j]);
                node.left = element;
                r.push(node);
            });
        } else {
            let leftArray = generateTreesWithNum(left);
            let rightArray = generateTreesWithNum(right);
            for(let m = 0; m < leftArray.length; m++) {
                for(let n = 0; n < rightArray.length; n++) {
                    let node  = new TreeNode(arrays[j]);
                    node.left = leftArray[m];
                    node.right = rightArray[n];
                    r.push(node);
                }
            }
        }
    }
    return r;
}
console.log(generateTrees(4));