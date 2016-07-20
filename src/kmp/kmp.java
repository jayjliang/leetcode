package kmp;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by LiangJ on 2016/4/7.
 */
public class kmp {
    public static void main(String[] args){
        kmp kmp = new kmp();
        String p = "ABCDABD";
        int[] next = kmp.getNext(p);
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
    }
    public int KmpSearch(String s,String p){
        int i=0;
        int j=0;
        int sLen = s.length();
        int pLen = p.length();
        int[] next = getNext(p);
        while(i<sLen&&j<pLen){
            if(j==-1||s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if(j==pLen){
            return i-j;
        } else{
            return -1;
        }
    }
    public int[] getNext(String p){
        int[] next = new int[p.length()];
        next[0] = -1;
        int k=-1;
        int j=0;
        while(j<p.length()-1){
            if(k==-1||p.charAt(j)==p.charAt(k)){
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
