package sort_algorithm;

/**
 * Created by LiangJ on 2016/3/30.
 */
public class heap_sort {
    public int length;
    public static void main(String[] args){
        int[] array = {16,4,10,14,7,9,3,2,8,1,17,12,5,13,15,20};
        heap_sort sort = new heap_sort();
        sort.sort(array);
    }
    public void setLength(int len){
        length = len;
    }
    public int getLength(){
        return length;
    }
    public void build(int[] array){
        setLength(array.length);
        for(int i=array.length/2-1;i>=0;i--){
            adjust(array,i);
        }
    }
    public void sort(int[] array){
        build(array);
        for (int i = array.length-1; i >0 ; i--) {
            swap(array,i,0);
            setLength(i);
            adjust(array,0);
        }
        for (int j = array.length-1; j >=0 ; j--) {
            System.out.print(array[j]+" ");
        }
    }
    public int getLeft(int index){
        int temp = index*2;
        return temp>getLength()?-1:temp;
    }
    public int getRight(int index){
        int temp = index*2+1;
        return temp>getLength()?-1:temp;
    }
    public void swap(int[] array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
    public void print(int[] array){
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public void adjust(int[] array,int index){

        int position=index;
        int left = getLeft(index+1);
        int right = getRight(index+1);
        if(left!=-1&&array[left-1]>array[index]){
            position = left-1;
        }
        if(right!=-1&&array[right-1]>array[position]){
            position = right-1;
        }
        if(position!=index){
            swap(array,position,index);
            adjust(array,position);
        }
    }
}
