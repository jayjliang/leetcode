package huaweiTest;

import java.util.Scanner;

/**
 * Created by LiangJ on 2016/3/25.
 */
public class Main {
    public static int deal(int[] result_type,int[] result_value,int type,int[] T,int count){
        for(int j=0;j<10;j++){
            int after = j+3;
            after = after>12?12:after;
            int before = j-2;
            before = before<0?0:before;
            if(T[j]>=1&&T[j+1]>=1&&T[j+2]>=1){
                T[j]--;
                T[j+1]--;
                T[j+2]--;
            } else if((T[j]==0||T[j]==2)&&T[j+1]==1&&T[j+2]==1&&T[after]<1){
                result_type[count] = type;
                result_value[count] = j;
                count++;
            } else if((T[j+1]==0||T[j+1]==2)&&T[j]==1&&T[j+2]==1){
                result_type[count] = type;
                result_value[count] = j+1;
                count++;
            } else if((T[j+2]==0||T[j+2]==2)&&T[j]==1&&T[j+1]==1&&T[before]<1){
                result_type[count] = type;
                result_value[count] = j+2;
                count++;
            }

        }
        return count;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String method = in.nextLine();
            int[] T = new int[13];
            int[] D = new int[13];
            int[] W = new int[13];
            int size = method.length();
            for(int i=0;i<size;i=i+2){
                char type = method.charAt(i+1);
                int posi = Integer.valueOf(method.charAt(i))-48;
//                System.out.println(posi);
                if(type=='T'){
                    T[posi]++;
                } else if(type=='D'){
                    D[posi]++;
                } else {
                    W[posi]++;
                }
            }
            int[] result_type = new int[13];
            int[] result_value = new int[13];
            int count = 0;
            count = deal(result_type,result_value,0,T,count);
            count = deal(result_type,result_value,1,D,count);
            count = deal(result_type,result_value,2,W,count);
            char[] change = {'T','D','W'};
            int all_count = 0;
            for(int j=0;j<13;j++){
                if(result_value[j]>0){
                   all_count++;
                }
            }
            System.out.println(all_count);
            if(all_count>0){
                for(int j=0;j<13;j++){
                    if(result_value[j]>0){
                        System.out.println(result_value[j]+""+change[result_type[j]]);
                    }
                }
            }


        }
    }
}
