package NewCoder;

/**
 * Created by LiangJ on 2016/4/26.
 */
public class find_in_array {
    public static void main(String[] args) {

    }
    public boolean Find(int [][] array,int target) {
        int row = array.length;
        int column = array[0].length;
        int x = row-1;
        int y = 0;
        while (x>=0&&y<column){
            if(array[x][y]==target){
                return true;
            } else if(array[x][y]<target){
                y++;
            } else {
                x--;
            }
        }
        return false;
    }
}
