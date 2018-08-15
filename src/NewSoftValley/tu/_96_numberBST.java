package NewSoftValley.tu;

/**
 * @Author : Yutong Jin
 * @date : 8/8/18
 * @Description :细致分析，不要急
 */
public class _96_numberBST {
    public int numTrees(int n) {
        int [] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1 ; i < n+ 1;i++){
            for(int j = 1 ;j <= i; j++){
                dp[i] += dp[j -1 ]* dp[i - j ];
            }
        }
        return dp[n];
    }
}
