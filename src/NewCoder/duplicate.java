package NewCoder;

/**
 * Created by LiangJ on 2016/4/25.
 */
public class duplicate {
    public static void main(String[] args) {

    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int[] map = new int[length];
        int position=0;
        for(int i=0;i<length;i++){
            if(map[numbers[i]]>0){
                position++;
            }
            map[numbers[i]]++;
        }
        if(position==0){
            return false;
        }
        for(int i=0;i<length;i++){
            if(map[numbers[i]]>1){
                duplication[0] =numbers[i];
                break;
            }
        }
        return true;
    }
}
