package NewSoftValley.tu;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        //DAG
        //一个一维数组
        //mn空间比较一下
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int [n ];
        for(int i = m - 1;i >= 0;i--){
            for(int j = n - 1; j >= 0 ;j--){
                if(i == m -1 && j == n - 1){
                    dp[i]= grid[i][j];
                }
                else if(i == m -1 ){
                    dp[i] = grid[i][j] + dp[j ];
                }
                else if(j == n - 1){
                    dp[i] = grid[i][j] + dp[j ];
                }
                else {
                    dp[i] = grid[i][j] + Math.min(dp[j +1 ] ,dp[j]);
                }
            }
        }
        return dp[0];
    }
}
