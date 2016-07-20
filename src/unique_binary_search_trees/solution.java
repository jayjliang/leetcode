package unique_binary_search_trees;

/**
 * Created by LiangJ on 2016/3/7.
 */
public class solution {
    public static void  main(String[] args){
        Solu s = new Solu();
        System.out.println(s.numTrees(5));
    }
};
class Solu {
    public int numTrees(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                result[i] += result[j]*result[i-1-j];
            }
        }
        return result[n];
    }
};
