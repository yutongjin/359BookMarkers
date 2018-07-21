package problems.DP;

/**
 * @Author : Yutong Jin
 * @date : 7/19/18
 * @Description :
 */
public class nOfMAllWrong {
    public static void main(String [] args){
        int m = 10;
        int n = 7;
        int [][] dp = new int[m+1][n+1];
        //base case
        for(int i = 0 ; i <= m ;i++){
            dp[i][0] = i;// i 选 0的话 有i种全错的可能
            dp[i][1] = i -1; // i 选1 的话有i- 1种情况
        }
        //general case
        for(int a = 3; a <= m ; a++){
            for(int b = 2; b <= n&& b <a; b++){
                dp[a][b] = (b - 1)* dp[a - 1][b - 2] + (a - b)* dp[a - 1][b - 1];
                System.out.println(a + "选 " + b  +"全错的情况共有 "+ dp[a][b] +"种");
            }
        }
        System.out.println(dp[m][n]);
    }
}
