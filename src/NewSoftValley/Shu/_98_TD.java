package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/31/18
 * @Description :
 */
public class _98_TD {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        boolean []res =  new boolean[1];
        res[0] = true;
        // List<TreeNode> path = new ArrayList<>();
        dfs(root,res,null,null);
        return res[0];
    }
    private void dfs( TreeNode root,boolean[]res,Integer min,Integer max ){

        if(!res[0]){
            return ;
        }
        if((min != null && min >= root.val) ||(max != null && max <= root.val) ){
            res[0] = false;
        }
        if(root.left != null){
            dfs(root.left,res,min,new Integer(root.val));
        }
        if(root.right != null){
            dfs(root.right,res,new Integer(root.val),max);
        }

    }
}
