package bop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by LiangJ on 2016/4/23.
 */
public class main {
    public static void main(String[] args){
        main main = new main();
        float[] a = {(float) 12.5, (float) 7.2, (float) 5.3,(float)5.3};
//        main.Puzzle(a);
        main.three(2);
    }
    public int[] Puzzle(float[] a) {
        float[] result = new float[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = a[i];
        }
        Arrays.sort(a);
        int len = a.length;
        int index=0;
        int count=0;
        int[] out = new int[len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(a[j]==result[i]){
                    out[i] = j;
                    break;
                }
            }
//            System.out.println(result[i]);
//            System.out.println(out[i]);
        }

        return out;
    }

    public int two(int[] a){
        boolean check = true;
        for(int i=1;i<a.length;i++){
            if(a[1]-a[0]>=2){
                check = false;
                break;
            }
        }
        Arrays.sort(a);
        int len = a.length;
        int start = a[0];
        int end = a[len-1];
        if(len%2==1){
            return a[(len-1)/2];
        } else {
            if(check){
                return a[(len-1)/2];
            } else {
                return a[0]+(end-start)/2;
            }

        }

    }

    class Node{
        int x;
        int y;
        int count;
        public Node(int x,int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
//    public String Puzzle(int r1, int c1, int r2, int c2, String[] strs) {
//        int row = strs.length;
//        int column = strs[0].length();
//        int[][] map = new int[row][column];
//        for(int i=0;i<row;i++){
//            for(int j=0;j<column;j++){
//                if(strs[i].charAt(j)=='#'){
//                    map[i][j] = 0;
//                } else {
//                    map[i][j] = 1;
//                }
//            }
//        }
//        Stack stack = new Stack();
//        stack.push(new Node(r1,c1,1));
//        int result=0;
//        while (!stack.isEmpty()){
//            Node temp = (Node) stack.pop();
//            int x = temp.x;
//            int y = temp.y;
//            int count = temp.count;
//            //left
//            if((x-1==r2&&y==c2)||(x+1==r2&&y==c2)||(x==r2&&y-1==c2)||(x==r2&&y+1==c2)){
//                result = count+1;
//                break;
//            }
//            if(x-1>=0&&map[x-1][y]==1){
//                stack.add(new Node(x-1,y,count+1));
//            }
//            if(x+1<row&&map[x+1][y]==1){
//                stack.add(new Node(x+1,y,count+1));
//            }
//            if(y-1>=0&&map[x][y-1]==1){
//                stack.add(new Node(x,y-1,count+1));
//            }
//            if(y+1<column&&map[x][y+1]==1){
//                stack.add(new Node(x,y+1,count+1));
//            }
//        }
//        if(result==0){
//            return "No path found!";
//        } else {
//            return String.valueOf(result);
//        }
//    }

    public static String[] out;
    public static int count=0;
    public static String[] three(int n) {
        // the Strings contain only parentheses
        if(n<1){
            out = new String[1];
            out[0] = "";
            return out;
        }
        if(n==1){
            out = new String[1];
            out[0] = "()";
            return out;
        }
        int[] h = new int[n+1];
        h[0] = h[1] = 1;
        for(int i=2;i<=n;i++){
            h[i] = 0;
            for(int j=0;j<i;j++){
                h[i]+=h[j]*h[i-j-1];
            }
        }
        out= new String[h[n]];
        System.out.println(h[n]);
        PrintAll("",n,n);
        for(String i:out){
            System.out.println(i);
        }
        return out;
    }

    public static void PrintAll(String All,int left,int right)
    {
        if(right==0&&left==0)
        {
            System.out.println(All);
            out[count++] = All;
        }
        if(left>0)
        {
            PrintAll(All+"(",left-1,right);
        }
        if(right>0&&left<right)
        {
            PrintAll(All+")",left,right-1);
        }
    }
}
