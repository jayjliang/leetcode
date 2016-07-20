package NewCoder;

import java.util.ArrayList;

/**
 * Created by LiangJ on 2016/4/18.
 */
public class Main {
    public static void main(String[] args){
        String input="hello ";
        int sum = 6;
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(0);
//        left.left = new TreeNode(1);
//        left.right = new TreeNode(1);
        TreeNode right = new TreeNode(0);
//        right.left = new TreeNode(0);
//        right.left.left = new TreeNode(0);
//        right.left.right = new TreeNode(1);
        root.left = left;
        root.right=right;
        LongestPath path = new LongestPath();
        System.out.println(path.findPath(root));

    }


};
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
class MaxPath {
    public int max=1;
    public int get(TreeNode node){
        if(node==null){
            return 0;
        }
        cal(node.left,1,node.val);
        cal(node.right,1,node.val);
        return max;
    }
    public void cal(TreeNode node,int count,int value){
        max = Math.max(count,max);
        if(node==null){
            return;
        }
        if(node.val==value){
            cal(node.left,count+1,value);
            cal(node.right,count+1,value);
        } else {
            cal(node.left,1,node.val);
            cal(node.right,1,node.val);
        }
    }
}
class LongestPath {
    MaxPath path = new MaxPath();
    public int findPath(TreeNode root) {
        if(root==null){
            return 0;
        }
        return find(root,0);
    }
    public int find(TreeNode start,int count){
        if(start.left==null&&start.right==null){
            return 1;
        }
        else if(start.left!=null&&start.right==null){
            count= path.get(start);
        }
        else if(start.right!=null&&start.left==null){
            count= path.get(start);
        } else {
            int left =path.get(start.left);
            int right = path.get(start.right);
            int temp = Math.max(left,right);
            if(start.val==start.left.val&&start.val==start.right.val){
                count = Math.max(temp,count+1+other(start.left,1,start.val)+other(start.right,1,start.val));
            } else {
                count=temp;
            }
        }
        return count;
    }
    public int other(TreeNode node,int count,int value){
        if(node==null){
            return count-1;
        }
        if(node.val!=value){
            return count;
        } else {
            return Math.max(other(node.left,count+1,value),other(node.right,count+1,value));
        }
    }
}

//    void longestpath(TreeNode* root,int &count,int &countincluderoot){
//        if(root == NULL) {count = 0;return ;}
//        int countleft = 0,countright = 0;
//        int countincluderootLeft = 0,countincluderootRight = 0;
//        longestpath(root->left,countleft,countincluderootLeft);
//        longestpath(root->right,countright,countincluderootRight);
//
//        countincluderoot = 1;
//        count = 1;
//        if (root->left && root->right && root->left->val == root->val && root->right->val == root->val)
//        {
//            count += countincluderootLeft+countincluderootRight;
//            countincluderoot = 1+ max(countincluderootLeft,countincluderootRight);
//        }
//        else if (root->left && root->left->val == root->val)
//        {
//            count += countincluderootLeft;
//            countincluderoot = max(1,countincluderootLeft)+1;
//        }
//        else if (root->right && root->right->val == root->val)
//        {
//            count += countincluderootRight;
//            countincluderoot = max(1,countincluderootRight)+1;
//        }
//
//        count = max(count,max(countleft,countright));
//    }
//    int findPath(TreeNode* root) {
//        int cnt = 0;
//        int cc;
//        longestpath(root,cnt,cc);
//        return cnt;
//    }