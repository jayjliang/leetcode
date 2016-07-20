package sort_algorithm;

/**
 * Created by LiangJ on 2016/3/30.
 */
public class quick_sort {
    public static void main(String[] args){
//        int[] array = {16,4,2,14,7,9,3,20,8,1,17,12,5,13,15,10};
        int[] array = {0,1,4,3};
        quick_sort quick_sort = new quick_sort();
        quick_sort.sort(array,0,array.length-1);
        quick_sort.print(array);
    }

    public void sort(int[] array,int start,int end){
        if(start<end){
            int par = pardition(array,start,end);
            sort(array,0,par-1);
            sort(array,par+1,end);
        }
    }
    public void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    public void swap(int[] array,int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }
    public int pardition(int[] array,int start,int end){
        int index = end;
        System.out.println(array[index]);
        int position = start;
        for(int i=start;i<end;i++){
            if(array[i]<array[index]){
                swap(array,position,i);
                position++;
            }
        }
        swap(array,position,end);
        return position;
    }
}
