package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/17/18
 * @Description :Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 *
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 *     10
 *     / \
 *    5  15
 *   / \   \
 *  1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */
//注意几点
    //1 需要全局变量统计出现的最大size bst
    //2 注意bst的定义是：root 比 左子树最大的数还要大，柚子树比右边最小的还要小。
    //3 边界条件，min max integer情况注意
public class _333_LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root)._res;
    }
    private Result dfs(TreeNode root){
        //base case leaf node;
        if(root.left == null && root.right == null){
            return new Result(root.val,root.val, true,1);
        }

        Result leftResult = root.left == null ? new Result(0,Integer.MIN_VALUE,true,0) : dfs(root.left);
        Result rightResult =  root.right == null ? new Result(Integer.MAX_VALUE,0,true,0) : dfs(root.right);

        boolean isBST = leftResult._isBST && rightResult._isBST && (root.left == null || root.val > leftResult._max) && (root.right == null ||root.val < rightResult._min );
        int res = isBST? (1 + leftResult._res + rightResult._res) : Math.max(leftResult._res,rightResult._res);
        int min = isBST  ? (root.left != null ?leftResult._min : root.val) : 0;
        int max = isBST ? (root.right != null ?rightResult._max : root.val) : 0;

        return new Result(min,max,isBST,res);
    }
    class Result {
        int _min;
        int _max;
        boolean _isBST;
        int _res;
        Result(int min,int max, boolean isBST , int res){
            _min = min;
            _max = max;
            _isBST = isBST;
            _res = res;
        }
    }
}
