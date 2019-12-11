var longestUnivaluePath = function(root) {
    if (!root) {
        return 0;
    }
    let max = {max: 0};
    getMax(root, max);
    return max.max;
};
function getMax(root, max) {
    if (!root) {
        return 0;
    }
    let leftLen = getMax(root.left);
    let rightLen = getMax(root.right);

    let left = 0;
    let right = 0;

    if (root.left && root.left.val == root.val) {
       left = leftLen + 1;
    }
    if (root.right && root.right.val == root.val) {
        right = rightLen + 1;
    }
    max.max = Math.max(max.max, left + right);
    return Math.max(left, right);

}
