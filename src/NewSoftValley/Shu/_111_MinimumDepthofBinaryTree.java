package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/17/18
 * @Description :Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class _111_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {

        if(root ==null)
            return 0;
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftResult = root.left == null ? Integer.MAX_VALUE : dfs(root.left);
        int rightResult = root.right == null ? Integer.MAX_VALUE :dfs(root.right);

        return 1 + Math.min(leftResult,rightResult);
//注意伪造 fake case
    }
}
