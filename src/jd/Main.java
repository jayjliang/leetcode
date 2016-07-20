package jd;

import java.util.*;

/**
 * Created by LiangJ on 2016/4/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String first_input = in.nextLine();
            String[] first_temp = first_input.split(" ");
            int number = Integer.valueOf(first_temp[0]);
            int result_number = Integer.valueOf(first_temp[1]);
            HashMap<Integer,Integer> buy = new HashMap<>();
            HashMap<Integer,Integer> sell = new HashMap<>();
            for(int i=0;i<number;i++){
                String input = in.nextLine();
                String[] temp = input.split(" ");
                int temp_number = Integer.valueOf(temp[2]);
                int temp_price = Integer.valueOf(temp[1]);
                if(temp[0].equals("B")){
                    if(buy.get(temp_price)==null){
                        buy.put(temp_price,temp_number);
                    } else{
                        buy.put(temp_price,temp_number+buy.get(temp_price));
                    }
                } else {
                    if(sell.get(temp_price)==null){
                        sell.put(temp_price,temp_number);
                    } else{
                        sell.put(temp_price,temp_number+sell.get(temp_price));
                    }
                }
            }

            int[] buy_array = new int[buy.size()];
            int buy_position = 0;
            int[] sell_array = new int[sell.size()];
            int sell_position = 0;

            Iterator iter = buy.entrySet().iterator();
            while (iter.hasNext()){
                Map.Entry entry = (Map.Entry) iter.next();
                Integer key = (Integer)entry.getKey();
                Integer value = (Integer)entry.getValue();
                buy_array[buy_position++] = key;
            }

            iter = sell.entrySet().iterator();
            while (iter.hasNext()){
                Map.Entry entry = (Map.Entry) iter.next();
                Integer key = (Integer)entry.getKey();
                Integer value = (Integer)entry.getValue();
                sell_array[sell_position++] = key;
            }

            Arrays.sort(buy_array);
            Arrays.sort(sell_array);
            int end =Math.min(result_number,sell.size());
            for(int j=sell.size()-1;j>=sell.size()-end;j--){
                System.out.println("S "+sell_array[j]+" "+sell.get(sell_array[j]));
            }
            end = Math.min(result_number,buy.size());
            for(int j=buy.size()-1;j>=buy.size()-end;j--){
                System.out.println("B "+buy_array[j]+" "+buy.get(buy_array[j]));
            }

        }
    }
}
