package NewCoder;

/**
 * Created by LiangJ on 2016/4/19.
 */
public class test {
    public int[] getPartition(int[][] land, int n, int m){
        int[] pre = predeal(land) ;
        int right_value = pre[pre.length-1] ;
        int min_value = right_value ;
        int min_pos = -1 ;
        for (int i=pre.length-1 ; i>=0 ;i--){
            int err_times = m * (i+1) + right_value - 2 * pre[i] ;
            if (err_times<=min_value) {
                System.out.println("change");
                min_value = err_times ;
                min_pos = i ;
            }
        }
        if (right_value<=min_value){
            min_value = right_value ;
            min_pos = -1 ;
        }
        int[] ret = new int[2] ;
        ret[0] = min_pos+1 ;
        ret[1] = min_pos+2 ;
        return ret ;

    }

    public static int[] predeal(int[][] land){
        int judge_num = land.length ;
        int temp_sum = 0 ;
        int land_num = land[0].length ;
        int[] ret = new int[land_num] ;
        for (int i=0;i<land_num;i++){
            for (int j=0;j<judge_num;j++){
                if (land[j][i] == 0) temp_sum++ ;
            }
            ret[i] = temp_sum ;
        }
        return ret ;
    }

}
