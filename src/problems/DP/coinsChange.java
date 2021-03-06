package problems.DP;

/**
 * @Author : Yutong Jin
 * @date : 6/17/18
 * @Description :You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class coinsChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [] dp = new int [amount + 1 ];
        dp[0] = 0 ;
        for(int i = 1 ; i <= amount; i ++){
            dp[i] = Integer.MAX_VALUE;

            for(int j = 0 ; j < n; j ++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) //两种特殊情况 [2] ,3     [5 ] 3
                    dp[i] = Math.min(dp[i] , dp[i - coins[j]] + 1 );
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount] ;
    }
}
