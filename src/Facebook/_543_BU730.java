package Facebook;



/**
 * @Author : Yutong Jin
 * @date : 7/31/18
 * @Description :
 * //-1 伪造得很精髓 哈哈哈
 */
public class _543_BU730 implements _543_DiameterofBinaryTree{
    @Override
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0 ;
        return dfs(root)._res;
    }
    private Result dfs(TreeNode node){
        //leaf node
        if(node.left == null && node.right == null){
            return new Result(0,0);
        }

        Result leftResult = node.left == null ? new Result (-1,-1) : dfs(node.left);
        Result rightResult =  node.right == null ? new Result (-1,-1) : dfs(node.right);
        int res = Math.max(Math.max(leftResult._res,rightResult._res),leftResult._toRoot + rightResult._toRoot + 2);
        int toRoot = Math.max(leftResult._toRoot,rightResult._toRoot) + 1;

        return new Result(res,toRoot);
    }



    class Result{
        int _res;
        int _toRoot;
        Result(int res,int toRoot){
            _res= res;
            _toRoot = toRoot;
        }

    }
}
