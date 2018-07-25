package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/17/18
 * @Description :Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 *              according to the LCA definition.
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class _236_LowestCommonAncestorofaBinaryTree implements _236_ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        return dfs(p,q,root)._res;
    }
    private Result dfs(TreeNode p, TreeNode q,TreeNode root ){
        // base case leaf
        if(root.left == null && root.right == null){
            if(root == p){
                return new Result(false,true,null);
            }
            else if(root == q){
                return new Result(true,false, null);
            }
            else return  new Result(false,false, null);
        }


        // general case;
        Result leftResult = root.left == null ? new Result (false,false,null):dfs(p,q,root.left);
        Result rightResult =root.right == null ? new Result (false,false,null):dfs(p,q,root.right);

        if(leftResult._res != null)
            return new Result(true,true,leftResult._res);
        if(rightResult._res != null)
            return new Result(true,true,rightResult._res);
        if((leftResult._hasQ && root == p) ||(leftResult._hasP && root == q)|| (rightResult._hasQ && root == p) ||(rightResult._hasP && root == q) || (leftResult._hasQ && rightResult._hasP) || (leftResult._hasP && rightResult._hasQ))
            return new Result(true,true,root);
        return new Result(leftResult._hasQ || rightResult._hasQ || root == q,leftResult._hasP || rightResult._hasP || root == p,null );



    }
    class Result{
        boolean _hasQ;
        boolean _hasP;
        TreeNode _res;
        public Result(boolean hasQ,boolean hasP,TreeNode res){
            _res = res;
            _hasQ= hasQ;
            _hasP = hasP;
        }
    }
}
