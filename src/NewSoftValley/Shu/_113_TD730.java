package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/30/18
 * @Description :
 * ArrayList<Integer> path 形式参数里需要加上范型哦
 */
public class _113_TD730  implements _113_{
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root,result,sum,new ArrayList<>());
        return result;

    }
    private void dfs(TreeNode root, List<List<Integer>> result ,int sum, ArrayList<Integer> path){
        //op at node
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum)
                result.add(new ArrayList<>(path));
        }
        //go done to children

        if(root.left != null)
            dfs(root.left,result,sum - root.val,path);
        if(root.right != null)
            dfs(root.right,result,sum - root.val,path);

        //go up to parent
        path.remove(path.size() - 1);
    }
}
