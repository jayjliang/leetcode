package NewCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 16-8-2.
 */
public class N1019 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N1019 run = new N1019();
        while (in.hasNext()) {
            int a = in.nextInt();
            run.cal(a);
        }
    }

    public void cal(int input) {
        int[] bit = getBit(input);
        Arrays.sort(bit);
        int second = getValue(bit,1);
        int first = getValue(bit,2);
        int temp = first-second;
        if(temp==0) {
            System.out.println(transform(first)+" - "+transform(second)+" = 0000");
        } else if(temp==6174) {
            System.out.println(transform(first)+" - "+transform(second)+" = 6174");
        } else {
            System.out.println(transform(first)+" - "+transform(second)+" = "+transform(temp));
            cal(temp);
        }

    }
    public int[] getBit(int input) {
        int[] temp = new int[4];
        int index = 0;
        while (input>0) {
            temp[index++] = input%10;
            input = input/10;
        }
        return temp;
    }

    public int getValue(int[] bit,int type) {
        int sum = 0;
        if(type==1){
            for(int i=0;i<bit.length;i++) {
                sum += bit[i]*Math.pow(10,3-i);
            }
        } else {
            for(int i=bit.length-1;i>=0;i--) {
                sum += bit[i]*Math.pow(10,i);
            }
        }

        return sum;
    }

    public String transform(int input) {
        if(input<10) {
            String temp = String.valueOf(input);
            temp = "000" + temp;
            return temp;
        } else if(input<100) {
            String temp = String.valueOf(input);
            temp = "00" + temp;
            return temp;
        } else if(input<1000) {
            String temp = String.valueOf(input);
            temp = "0" + temp;
            return temp;
        } else {
            return String.valueOf(input);
        }
    }
}
