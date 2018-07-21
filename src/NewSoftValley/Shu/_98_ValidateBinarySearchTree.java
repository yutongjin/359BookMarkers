package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/17/18
 * @Description :Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */
public class _98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root ==null)
            return true;
        return dfs(root)._isBST;
    }
    private Result dfs(TreeNode root){
        //base case leaf;
        if(root.left == null && root.right == null){
            return new Result(root.val,root.val,true);
        }
        //general case nonleaf;

        Result leftResult = root.left == null ? new Result(99,Integer.MIN_VALUE,true) :dfs(root.left);
        Result rightResult = root.right == null ? new Result(Integer.MAX_VALUE,99,true) :dfs(root.right);

        boolean isBST = leftResult._isBST && rightResult._isBST && (root.left == null ||root.val > leftResult._max) && (root.right == null ||root.val < rightResult._min);
        int min = isBST ?( root.left != null ? leftResult._min :root.val) : 99;//
        int max = isBST ?( root.right != null ?rightResult._max :root.val): 99;//注意这里易错，
        return new Result(min,max,isBST);
    }
    class Result{
        int _min;
        int _max;
        boolean _isBST;
        Result(int min, int max, boolean isBST){
            _min = min;
            _max = max;
            _isBST = isBST;
        }
    }
}
