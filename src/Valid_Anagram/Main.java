package Valid_Anagram;

import java.util.*;

/**
 * Created by LiangJ on 2016/4/18.
 */
public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,1,1,3,3,2,2,2};
        solution.majorityElement(nums);
    }
};

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List list = new ArrayList();
        if(nums.length<2){
            for(int i:nums){
                list.add(i);
            }
            return list;
        }
        int num1 = -1;
        int count1 = 0;
        int num2 = -1;
        int count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(count1==0&&nums[i]!=num2){
                num1 = nums[i];
                count1=1;
                continue;
            }
            if(count2==0&&nums[i]!=num1){
                num2 = nums[i];
                count2=1;
                continue;
            }
            if(num1==nums[i]){
                count1++;
                continue;
            }
            if(num2==nums[i]){
                count2++;
                continue;
            }
            if(num1!=nums[i]){
                count1--;
            }
            if(num2!=nums[i]){
                count2--;
            }
        }
        System.out.println(num1+" "+num2);
        count1=count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1){
                count1++;
            }
            if(nums[i]==num2){
                count2++;
            }
        }
        System.out.println(count1+" "+count2);
        if(count1>nums.length/3){
            list.add(num1);
        }
        if(count2>nums.length/3&&num2!=num1){
            list.add(num2);
        }

        return list;
    }


}