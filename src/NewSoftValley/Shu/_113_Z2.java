package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/23/18
 * @Description :
 */
public class _113_Z2 implements _113_{

    @Override
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        dfs(root,sum,new ArrayList<>(),res);
        return res;
    }
    private void dfs(TreeNode root, int sum,List<Integer> tmp,List<List<Integer>> res){
        // op at parent
        tmp.add(root.val);
        if(root.left== null && root.right == null)
        {
            if(root.val == sum)
                res.add(new ArrayList(tmp));
        }
        //find child


        if(root.left != null )
            dfs(root.left,sum - root.val,tmp,res);
        if(root.right !=null)
            dfs(root.right,sum - root.val,tmp,res);
        // back tracking
        tmp.remove(tmp.size() - 1);


    }
}
