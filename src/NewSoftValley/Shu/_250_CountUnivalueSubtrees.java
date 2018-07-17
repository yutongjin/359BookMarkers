package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/16/18
 * @Description :Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * Example :
 *
 * Input:  root = [5,1,5,5,5,null,5]
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 * Output: 4
 */
public class _250_CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root)._cnt;
    }
    private Result dfs(TreeNode root){
        //1 base case : leaf
        if(root.left == null && root.right == null)
            return new Result(true, 1);
        // general case non-leaf;
        Result leftResult = root.left == null ? new Result(true, 0) : dfs(root.left);
        Result rightResult = root.right == null ? new Result(true, 0) :dfs(root.right);

        boolean isUni = leftResult._isUni && rightResult._isUni && (root.right == null || root.val == root.right.val )&& (root.left == null || root.val == root.left.val);

        int cnt = (isUni ? 1 : 0) + leftResult._cnt+ rightResult._cnt;
        return new Result(isUni,cnt);

    }
    class Result{
        boolean _isUni;
        int _cnt ;
        public Result(boolean isUni, int cnt){
            _isUni = isUni;
            _cnt = cnt;
        }
    }
}
