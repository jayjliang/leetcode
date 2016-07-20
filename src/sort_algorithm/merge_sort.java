package sort_algorithm;

/**
 * Created by LiangJ on 2016/3/31.
 */
public class merge_sort {
    public static void main(String[] args){
        int[] array = {16,4,2,14,7,9,3,20,8,1,17,12,5,13,10};
        merge_sort sort = new merge_sort();
        sort.sort(array,0,array.length-1);
        sort.print(array);
    }
    public void sort(int[] array,int left,int right){
        if(left<right) {
            int middle = (right - left) / 2 + left;
            sort(array, left, middle);
            sort(array, middle + 1, right);
            merge(array,left,middle,right);
        }
    }
    public void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    public void merge(int[] array,int left,int middle,int right){
        int i = left;
        int j = middle+1;
        int position=left;

        int[] temp = new int[array.length];
        while (i<=middle&&j<=right){
            if(array[i]<array[j]){
                temp[position++] = array[i++];
            } else {
                temp[position++] = array[j++];
            }
        }
        while (i<=middle){
            temp[position++] = array[i++];
        }
        while (j<=right){
            temp[position++] = array[j++];
        }
        while (left<=right){
            array[left] = temp[left++];
        }
    }
}
