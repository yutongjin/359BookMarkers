package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/17/18
 * @Description :Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
//
public class _124_BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root)._max;
    }
    private Result dfs(TreeNode root){
        //base case leaf;
        if(root == null)
            return new Result(0,Integer.MIN_VALUE);//此处初始值，可以是小于等于0的任意数
        //general case non-leaf;

        Result leftResult = dfs(root.left);
        Result rightResult =  dfs(root.right);
        // max to root 的最大值 有三个来源
        // 左边maxtoroot 加自己，自己，右边maxroot 加自己
        int maxToRoot = Math.max(Math.max(root.val,leftResult._maxToRoot + root.val),rightResult._maxToRoot + root.val);
        int max = Math.max(Math.max(Math.max(leftResult._max,rightResult._max),maxToRoot),root.val + leftResult._maxToRoot + rightResult._maxToRoot);
        // 该点处结果来源
        //1 左边结果
        //2 右边结果
        //3 通过自己加上两边的maxtoroot
        //4 自己的maxtoroot
        return new Result(maxToRoot,max);
    }
    class Result{
        int _maxToRoot;
        int _max;
        Result(int maxToRoot , int max){
            _maxToRoot = maxToRoot;
            _max = max;
        }
    }
}
