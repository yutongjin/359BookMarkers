package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/31/18
 * @Description :如果先从右遍历的话，就不需要替换了，如果左中右就需要替换一下！！！！！
 */
public class _199_TD730 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result,root,path,1);
        return result;
    }
    private void dfs(List<Integer> result,TreeNode root,List<Integer> path,int level){
        path.add(root.val);
        // op at node
        if(result.size() < level){
            result.add(root.val);
        }
        else result.set(level - 1,root.val);
        if(root.left != null){
            dfs(result,root.left,path,level + 1);
        }

        if(root.right != null){
            dfs(result,root.right,path,level + 1);
        }
        path.remove(path.size() - 1);
    }
}
