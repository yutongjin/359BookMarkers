package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/17/18
 * @Description :
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
 */
public class _104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root ==null)
            return 0;
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftResult = dfs(root.left);
        int rightResult = dfs(root.right);

        return 1 + Math.max(leftResult,rightResult);
    }
}
