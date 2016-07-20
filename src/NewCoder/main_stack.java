package NewCoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by LiangJ on 2016/4/23.
 */
public class main_stack {
    public static void main(String[] args) {

    }
    private Stack data = new Stack();
    private Stack minStack = new Stack();
    public void push(int node) {
        if(minStack.isEmpty()||node<(int)minStack.peek()){
            minStack.push(node);
        }
        data.push(node);
    }

    public void pop() {
        int node = (int)data.peek();
        if(node==(int)minStack.peek()){
            minStack.pop();
        }
        data.pop();
    }

    public int top() {
        int node = (int)data.peek();
        return node;
    }

    public int min() {
        return (int)minStack.peek();
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length<1){
            return 0;
        }
        int max = array[0];
        int sum = array[0];
        for(int i=1;i<array.length;i++){
            sum = (sum<0)?array[i]:array[i]+sum;
            max = Math.max(sum,max);
        }
        return max;
    }
    public int GetNumberOfK(int [] array , int k) {
        int count=0;
        for(int i=0;i<array.length;i++){
            if(k<array[i]){
                break;
            }
            if(k==array[i]){
                count++;
            }
        }
        return count;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList out = new ArrayList();
        int min = Integer.MAX_VALUE;
        int index = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=array.length-1;i>=0;i--){
            if(array[i]>sum/2-1){
                map.put(array[i],1);
            } else {
                break;
            }
        }
        for(int i=0;i<array.length;i++){
            if(array[i]>sum/2){
                break;
            } else {
                if(map.containsKey(sum-array[i])){
                    if(array[i]*(sum-array[i])<min){
                        index = array[i];
                        min = array[i]*(sum-array[i]);
                    }
                }
            }
        }
        if(index>sum-index){
            index = sum-index;

        }
        if(index>0){
            out.add(index);
            out.add(sum-index);
        }

        return out;
    }
    /*
        逆序对个数
        使用归并思想
     */
    public int InversePairs(int [] array) {
        return merge_sort(array,0,array.length);
    }

    public int merge_sort(int[] array,int start,int end){
        if(start>=end){
            return 0;
        }
        int count=0;
        int mid = (end-start)/2+start;
        count+=merge_sort(array,start,mid);
        count+=merge_sort(array,mid+1,end);
        count+=merge(array,start,mid,end);
        return count;
    }
    public int merge(int[] array,int start,int mid,int end){
        int count=0;
        int i=start;
        int j=mid+1;
        int left = start;
        int[] temp = new int[array.length];
        int position = start;
        while (i<=mid&&j<end){
            if(array[i]<=array[j]){
                temp[position++] = array[i++];
            } else {
                count+=mid-i+1;
                temp[position++] = array[j++];
            }
        }
        while (i<=mid){
            temp[position++] = array[i++];
        }
        while (j<end){
            temp[position++] = array[j++];
        }
        while (left<end){
            array[left] =temp[left++];
        }

        return count;
    }
}

