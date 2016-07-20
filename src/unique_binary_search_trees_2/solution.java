package unique_binary_search_trees_2;

import java.util.*;
import java.util.concurrent.BlockingQueue;

/**
 * Created by LiangJ on 2016/3/7.
 */
public class solution {
    public static void  main(String[] args){
        Solu s = new Solu();
        s.generateTrees(3);
    }
};
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
   }
class Solu {

    public ArrayList<TreeNode> recurse(int start,int end){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start>end){
            result.add(null);
            return result;
        }
        for(int i=start;i<=end;i++){
            for(TreeNode left:recurse(start,i-1)){
                for (TreeNode right:recurse(i+1,end)){
                    TreeNode root = new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    result.add(root);
                }
            }
        }
    return result;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        } else {
            return recurse(1,n);
        }
    }

    public ArrayList<TreeNode> generateTree(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        ArrayList<TreeNode> leftTree = new ArrayList<TreeNode>();
        ArrayList<TreeNode> rightTree = new ArrayList<TreeNode>();
        for (int i = start; i <= end; i++) {
            leftTree = generateTree(start, i - 1);
            rightTree = generateTree(i + 1, end);
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode n = new TreeNode(i + 1);
                    n.left = leftTree.get(j);
                    n.right = rightTree.get(k);
                    result.add(n);
                }
            }
        }
        return result;
    }


    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList output = new ArrayList();
        Queue one =  new LinkedList();
        int start=0,end=1;
        if(pRoot==null){
            return output;
        }
        one.add(pRoot);
        ArrayList temp = new ArrayList();
        while (!one.isEmpty()){
            TreeNode node = (TreeNode) one.remove();
            temp.add(node.val);
            start++;
            if(node.left!=null){
                one.add(node.left);
            }
            if(node.right!=null){
                one.add(node.right);
            }
            if(start==end){
                start = 0;
                end = one.size();
                temp.clear();
            }
        }


        return output;
    }

};