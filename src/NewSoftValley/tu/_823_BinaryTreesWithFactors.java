package NewSoftValley.tu;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _823_BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] a) {
        Arrays.sort(a);
        long result = 0 ;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < a.length ; i++){
            hm.put(a[i],i);
        }
        long [] dp = new long[a.length];
        for(int i = 0 ; i < a.length ;i++){
            dp[i] = 1;
            for(int j = 0 ; j < i ;j++){
                if(a[j] >(int)Math.sqrt(a[i]))
                    break;

                if(a[i] % a[j] == 0 ){

                    int rightValue  =  a[i] / a[j];
                    if(hm.containsKey(rightValue)){
                        int rightIndex = hm.get(rightValue);
                        if(j != rightIndex)
                            dp[i] += 2 * dp[rightIndex] * dp[j];
                        else
                            dp[i] += dp[rightIndex] * dp[j];

                    }
                }
            }
            result+= dp[i];
        }
        return  (int) (result % ((int)1000000007));
    }
}
