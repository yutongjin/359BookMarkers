package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/16/18
 * @Description :
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

5
/ \
4   8
/   / \
11  13  4
/  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
//难在于必须要经过leaf点才算是一条路径，就算到该点符合条件了，如果不是叶子结点 其柚子树返回值也为false；
    //44 45 行 为经典；
public class _112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        return dfs(root,sum);

    }
    public boolean dfs(TreeNode root,int sum){
        // base case leaf

        if(root.left == null && root.right == null){
            if(root.val == sum)
                return true;
            else return false;
        }

        //general case non- leaf;

        boolean leftResult = root.left == null ?false : dfs(root.left,sum - root.val);
        boolean rightResult =  root.right == null ? false :dfs(root.right,sum - root.val);
        return leftResult || rightResult;

    }
}
