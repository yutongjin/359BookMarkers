package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _337_houseRobber3 {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        return dfs(root)._res;
    }
    private Result dfs(TreeNode root){
        // leaf node
        if(root.left == null && root.right == null){
            return new Result(root.val,0);
        }

        //non leaf
        int res = 0 ;
        int resNotSelf = 0;

        Result leftResult = root.left != null ? dfs(root.left) : new Result(0,0);
        Result rightResult =root.right != null ? dfs(root.right) :new Result(0,0);

        res = Math.max(root.val + leftResult._resNotSelf + rightResult._resNotSelf, leftResult._res+ rightResult._res);
        resNotSelf = leftResult._res + rightResult._res;

        return new Result(res,resNotSelf);
    }
    class Result{

        int _res;
        int _resNotSelf;
        Result(int res,int resNotSelf){
            _res  = res;
            _resNotSelf = resNotSelf;
        }
    }
}
