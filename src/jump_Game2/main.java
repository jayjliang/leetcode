package jump_Game2;

import netscape.javascript.JSObject;

/**
 * Created by LiangJ on 2016/1/10.
 */
public class main {
    public static void main(String []args){
        int nums[] = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};

        int result = 0;;
        main a = new main();
        result = a.Jump(nums);
        System.out.println(result);
    }

    public int Jump(int[] nums) {
        int tempmax=0;
        int max=0;
        int temp=0;
        int[] record = new int[nums.length];
        int j=0;
        if(nums.length==1){
            return 1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]+i>max){
                if(i>tempmax){
                    j++;
                    tempmax = max;
                }
                max = nums[i]+i;
                record[j] = max;
                if(record[j]>=nums.length-1){
                    for(int k=0;k<j+1;k++){
                        System.out.println(record[k]);
                    }
                    return j+1;
                }
            }
        }
        return j+1;
    }
}
