package NewSoftValley.tu;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        //找定义！！！！找转移方程！！！！
        //dp[i][j] = Math.min(dp[i][j - 1],dp[i - 1][j],dp[i - 1][j - 1] ) + 1;
        final int n = matrix.length;
        final int m = matrix[0].length;

        int[]bian = new int[m];
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0  ;j < m ; j ++){
                if(i ==0 || j == 0){
                    bian[j] = matrix[i][j] - '0';
                }

                else {

                    if(bian[j] == bian[j - 1]){
                        bian[j] =  bian[j] + matrix[i-bian[j]][j - bian[j]] - '0';
                    }
                    else {
                        bian[j] = 1 + Math.min(bian[j],bian [j - 1]);
                    }
                    bian[j] *= matrix[i][j] - '0';
                }
                result = Math.max(result,bian[j] * bian[j]);
            }
        }
        return result;
    }
}
