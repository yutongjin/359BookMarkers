package Facebook;

import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[n];
        for(int i = triangle.size() - 1; i >=0 ;i--){
            for(int j = 0 ; j < triangle.get(i).size();j++){
                if(i == triangle.size() - 1){
                    dp[j] = triangle.get(i).get(j);
                }
                else {
                    dp[j] = Math.min(dp[j + 1],dp[j]) + triangle.get(i).get(j);
                }
            }

        }
        return dp[0];
    }
}
