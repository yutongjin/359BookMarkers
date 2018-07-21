package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/17/18
 * @Description :Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   10 10
 *     /  \
 *    2   3
 *
 * Output: True
 * Explanation:
 *     5
 *    /
 *   10
 *
 * Sum: 15
 *
 *    10
 *   /  \
 *  2    3
 *
 * Sum: 15
 * Example 2:
 * Input:
 *     1
 *    / \
 *   2  10
 *     /  \
 *    2   20
 *
 * Output: False
 * Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
 * Note:
 * The range of tree node value is in the range of [-100000, 100000].
 * 1 <= n <= 10000
 */
//注意 sum == 0 的情况！！！一定要断链！才可以
public class _663_EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        if(root == null)
            return false;
        int sum = sum(root);
        return dfs(root,sum)._res;
    }
    private int sum(TreeNode root){
        if(root == null)
            return 0;
        else return sum(root.left )+ sum(root.right ) + root.val;
    }
    private Result dfs(TreeNode root, int sum){
        //base case
        if(root == null)
            return new Result(0,false);
        //general case non leaf
        Result leftResult = dfs(root.left,sum);
        Result rightResult = dfs(root.right,sum);
        boolean res = leftResult._res || rightResult._res || (root.left != null &&leftResult._sum * 2 == sum) || (root.right != null &&( rightResult._sum ) * 2== sum) ;
        int sumRoot = root.val + leftResult._sum + rightResult._sum;
        return new Result(sumRoot,res);

    }
    class Result{
        int _sum;
        boolean _res;
        Result(int sum, boolean res){
            _sum = sum;
            _res = res;
        }
    }
}
