/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxPathSum = function(root) {
    if (!root) {
        return 0;
    }
    let max = {max: 0};
    getMax(root, max);
    return max.max;
};

function getMax(root, max) {
    if (!root) {
        return [0,0,0];
    }
    let leftLen = getMax(root.left, max);
    let rightLen = getMax(root.right, max);

    let leftmax = Math.max(leftLen[0], leftLen[1], 0) + root.val;
    let rightMax = Math.max(rightLen[0], rightLen[1], 0) + root.val;
    let mergeMax = leftmax + rightMax - root.val;

    max.max = Math.max(max.max, leftmax, rightMax, mergeMax);
    return [leftmax, rightMax, mergeMax];

}
