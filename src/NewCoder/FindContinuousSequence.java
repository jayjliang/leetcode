package NewCoder;

import java.util.ArrayList;

/**
 * Created by LiangJ on 2016/4/25.
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        FindContinuousSequence one = new FindContinuousSequence();
        one.FindContinuousSequence(3);
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList list = new ArrayList();
        int start = 1;
        int end=2;
        int currsum = start+end;
        int middle = sum/2+1;
        while (start<=middle){
            System.out.println(start+" "+end+" "+currsum);
            if(currsum<sum){
                end++;
                currsum+=end;
            } else if(currsum>sum){
                currsum-=start;
                start++;
            } else {
                ArrayList temp = new ArrayList();
                for(int i=start;i<end;i++){
                    temp.add(i);
                }
                list.add(temp);
                currsum-=start;
                start++;
            }
        }
//            for(int i=(sum+1)/2;i>=2;i--){
//                if(i%2==0){
//                    if((sum-i/2)%i==0){
//                        System.out.println();
//                        int middle = (sum-i/2)/i;
//                        if(middle+i/2<=sum&&(middle-i/2+1)>=1){
//                            ArrayList temp = new ArrayList();
//                            for(int j=middle-i/2+1;j<=middle+i/2;j++){
//                                temp.add(j);
//                            }
//                            list.add(temp);
//                        }
//                    }
//                } else {
//                    if(sum%i==0){
//                        int middle = sum/i;
//                        if(middle+i/2<=sum&&middle-i/2>=1){
//                            ArrayList temp = new ArrayList();
//                            for(int j=middle-i/2;j<=middle+i/2;j++){
//                                temp.add(j);
//                            }
//                            list.add(temp);
//                        }
//                    }
//                }
//
//            }
        return list;
    }
}
