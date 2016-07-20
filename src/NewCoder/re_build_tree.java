package NewCoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by LiangJ on 2016/4/26.
 */
public class re_build_tree {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        int[] temp = Arrays.copyOfRange(array,0,2);
        for (int i: temp) {
            System.out.println(i);
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length<1){
            return null;
        } else {
            TreeNode root = null;
//            build(root,pre,in);
            return build(root,pre,in);
        }
    }

    public TreeNode build(TreeNode node,int[] pre,int[] in){
        if(in.length<1){
            return null;
        }
        if(in.length==1){
            node = new TreeNode(in[0]);
            return node;
        }
        node = new TreeNode(pre[0]);
        int position = get_position(in,pre[0]);
        int[] temp_left = Arrays.copyOfRange(in,0,position);
        int[] temp_right = Arrays.copyOfRange(in,position+1,in.length);
        int[] pre_left = Arrays.copyOfRange(pre,1,1+position);
        int[] pre_right = Arrays.copyOfRange(pre,1+position,pre.length);
        node.left = build(node.left,pre_left,temp_left);
        node.right = build(node.right,pre_right,temp_right);
        return node;
    }
    public int get_position(int[] array,int target){
        for(int i=0;i<array.length;i++){
            if(array[i]==target){
                return i;
            }
        }
        return -1;
    }
}
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
