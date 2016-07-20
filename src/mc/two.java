package mc;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by LiangJ on 2016/4/6.
 */
public class two {
    public static String transfor(String ip){

        char[] result = {'0','1'};
        StringBuilder builder = new StringBuilder();
        String[] ips = ip.split("\\.");
        for(int i=0;i<ips.length;i++){
            char[] bit = {'0','0','0','0','0','0','0','0'};
            int number = Integer.valueOf(ips[i]);
            int posi = 7;
            while(number>0){
                int value = number%2;
                bit[posi--] = result[value];
                number = number/2;
            }
            builder.append(new String(bit));
        }
        return  builder.toString();
    }
    public static boolean judge(String init,String data,int bit){
        for(int i=0;i<bit;i++){
            if(init.charAt(i)!=data.charAt(i)){
                return false;
            }
        } return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String line = in.nextLine();
            String[] line_temp = line.split(" ");
            int rule_count = Integer.valueOf(line_temp[0]);
            int request_count = Integer.valueOf(line_temp[1]);

            int[] rule_type = new int[rule_count];

            HashMap<String,Integer> allow_ip = new HashMap<>();
            HashMap<String,Integer> deny_ip = new HashMap<>();
            String[] allow_ips = new String[rule_count];
            int[] allow_ips_bit = new int[rule_count];
            String[] deny_ips = new String[rule_count];
            int[] deny_ips_bit = new int[rule_count];
            int allow_ips_count = 0;
            int deny_ips_count = 0;
            for(int i=0;i<rule_count;i++){
                String input = in.nextLine();
                String[] input_temp = input.split(" ");
                String[] temp = input_temp[1].split("/");
                if(input_temp[0].equals("allow")){
                   if(temp.length==2){
                        allow_ips[allow_ips_count] = transfor(temp[0]);
                        allow_ips_bit[allow_ips_count++] = Integer.valueOf(temp[1]);
                       rule_type[i] = 3;
                   } else {
                       allow_ip.put(input_temp[1],1);
                       rule_type[i] = 1;
                   }
                } else {
                    if(temp.length==2){
                        deny_ips[deny_ips_count] = transfor(temp[0]);
                        deny_ips_bit[deny_ips_count++] = Integer.valueOf(temp[1]);
                        rule_type[i] = 2;
                    } else {
                        deny_ip.put(input_temp[1],1);
                        rule_type[i] = 0;
                    }
                }
            }
            for(int j=0;j<request_count;j++){
                String input_case = in.nextLine();
                int state=0;
                for(int i=0;i<rule_count;i++){

                    if(rule_type[i]==0){
                        if(deny_ip.get(input_case)!=null){
                            System.out.println("NO");
                            break;
                        }
                    } else if(rule_type[i]==1){
                        if(allow_ip.get(input_case)!=null){
                            System.out.println("YES");
                            break;
                        }
                    } else if(rule_type[i]==2){
                        String ip_value = transfor(input_case);
                        for(int k=0;k<deny_ips_count;k++){
                            if(judge(deny_ips[k],ip_value,deny_ips_bit[k])){
                                System.out.println("NO");
                                state=1;
                                break;
                            }
                        }
                    } else {
                        String ip_value = transfor(input_case);
                        for(int k=0;k<allow_ips_count;k++){
                            if(judge(allow_ips[k],ip_value,allow_ips_bit[k])){
                                System.out.println("YES");
                                state=1;
                                break;
                            }
                        }

                    }
                    if(state==1){
                        break;
                    }
                }
                if(state==0){
                    System.out.println("YES");
                }
            }
        }


    }
}
