/**
 * Created by LiangJ on 2016/4/7.
 */
public class counting_bits {
    public static void main(String[] args){
        counting_bits bits = new counting_bits();
        System.out.println(bits.countBits(31).length);
    }
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        if(num<2){
            return dp;
        }
        int count = 1;
        int posotion=2;
        while(posotion<=num){
            int temp = (int)Math.pow((double)2,(double)count);
            int number = temp;
            while (temp>number/2&&posotion<=num){
                dp[posotion] = dp[posotion++-number/2];
                temp--;
            }
            while (temp>0&&posotion<=num){
                dp[posotion] = dp[posotion++-number/2]+1;
                temp--;
            }
            count++;
        }
        return dp;
    }
}
