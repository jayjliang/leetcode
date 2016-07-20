package NewCoder;

/**
 * Created by LiangJ on 2016/4/25.
 */
public class NumberOf1Between1AndN_Solution {
    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution solution = new NumberOf1Between1AndN_Solution();
        System.out.println(solution.NumberOf1Between1AndN_Solution(34567));

//        System.out.println(solution.get(0,3));
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for(int i=1;i<=n;i*=10){
            int left = n/i;
            int right = n%i;
            int bit = left%10;
            if(bit>=2){
                count+=(left/10+1)*i;
            } else if(bit==1){
                count+=(left/10)*i+right+1;
            } else {
                count+=(left/10)*i;
            }
        }
        return count;
    }
    public int get(int number,int bit){
        int count=0;
        for(int i=1;i<bit-1;i++){
            int all = c(i,bit-1);
            int sub = c(i-1,bit-2);
//            System.out.println(i+" "+all+" "+Math.pow(9,bit-1-i)*i);
//            count+=(all-sub)*(8*Math.pow(10,bit-2-i))*i;
            count+=(all)*(Math.pow(9,bit-1-i))*i;
        }
        count+=bit-1;
        return count;
    }

    public int c(int top,int bottom){
        int result = 1;
        for(int i=bottom;i>bottom-top;i--){
            result*=i;
        }
        for(int i=top;i>=1;i--){
            result/=i;
        }
        return result;
    }
}
