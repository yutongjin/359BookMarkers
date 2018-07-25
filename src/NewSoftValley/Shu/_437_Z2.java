package NewSoftValley.Shu;

import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 7/23/18
 * @Description :注意presum的题！！！判断的时候是pathsum - sum别弄反了
 */
public class _437_Z2 implements _437_ {
    @Override
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int[] res = new int [1];
        HashMap<Integer,Integer> path = new HashMap();
        path.put(0,1);
        dfs(root,res,sum,path,0);
        return res[0];

    }
    private void dfs(TreeNode root, int [] res, int sum , HashMap<Integer,Integer> path, int pathSum){
        //op at parent
        pathSum += root.val;
        if(path.containsKey(pathSum - sum ))
            res[0] += path.get(pathSum - sum );
        path.put(pathSum ,path.getOrDefault(pathSum ,0) + 1);
        //find child
        if(root.left !=null)
            dfs(root.left,res,sum,path,pathSum);
        if(root.right !=null)
            dfs(root.right,res,sum,path,pathSum);

        path.put(pathSum , path.get(pathSum) - 1);
    }
}
