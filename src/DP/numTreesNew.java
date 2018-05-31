package DP;

/**
 * @Author : Yutong Jin
 * @date : 5/30/18
 * @Description :
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class numTreesNew {
    public int numTrees(int n) {
        if(n <= 2)
            return n;
        int []dp = new int [n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n ; i++)
            for(int j = 0 ; j < i ; j++){
                dp[i] += dp[j] * dp[i - j - 1];//经典！
            }
        return dp[n ];

    }
}
