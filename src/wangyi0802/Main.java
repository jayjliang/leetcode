package wangyi0802;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

/**
 * Created by LiangJ on 2016/8/2.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] S = in.nextLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            int[] input = new int[N];
            String[] input$ = in.nextLine().split(" ");
            for(int i=0;i<N;i++) {
                input[i] =Integer.parseInt(input$[i]);
            }
            main.solution(N,K,input);
            System.out.println(main.count);
        }
    }
    public void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    public void merge(int[] a, int l, int mid, int r) {
        int[] b = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                //ans += mid - i + 1;
                ans = ans.add(new BigInteger(String.valueOf(mid - i + 1)));
                b[k++] = a[j++];
            }
        }
        while (i <= mid) {
            b[k++] = a[i++];
        }
        while (j <= r) {
            b[k++] = a[j++];
        }
        i = l;
        j = 0;
        while (i <= r) {
            a[i++] = b[j++];
        }
    }
    public BigInteger ans = BigInteger.ZERO;
    public int[] input$;
    public int K;
    public int count=0;
    public void cal(int[] buf) {
        int length = input$.length;
        int[] temp = new int[length];
        int index = 0;
        for(int i=0;i<length;i++){
            if(input$[i]==0){
                temp[i] = buf[index++];
            } else {
                temp[i] = input$[i];
            }
        }
        mergeSort(temp,0,length-1);
        if(ans.intValue()+K==length*(length-1)/2){
            this.count++;
        }
        this.ans = new BigInteger(String.valueOf(0));
    }

    public void perm(int[] buf,int start,int end){
        if(start==end){
//            for(int i=0;i<=end;i++){
//                System.out.print(buf[i]);
//            }
//            System.out.println();
            cal(buf);
        }
        else{
            for(int i=start;i<=end;i++){
                int temp=buf[start];
                buf[start]=buf[i];
                buf[i]=temp;
                perm(buf,start+1,end);
                temp=buf[start];
                buf[start]=buf[i];
                buf[i]=temp;
            }
        }
    }
    public int solution(int N,int K,int[] input) {
        this.count=0;
        int blank = 0;
        int[] temp = new int[N+1];
        this.input$ = input;
        this.K = K;
        for(int i =0;i<input.length;i++){
            temp[input[i]] = 0;
            if(input[i]==0){
                blank++;
            } else {
                temp[input[i]] = 1;
            }
        }
        int[] pai_number = new int[blank];
        int index = 0;
        for(int i=1;i<temp.length;i++){
            if(temp[i]==0){
                pai_number[index] =i;
                index++;
            }
        }
//        System.out.println(pai_number[0]+" "+pai_number[1]+" "+pai_number[2]);
        perm(pai_number,0,blank-1);
        return 0;
    }
}
