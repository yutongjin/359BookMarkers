package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/30/18
 * @Description :
 */
public class _113_BU730 implements _113_ {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return  new ArrayList<>();
        return dfs(root,sum);
    }
    List<List<Integer>> dfs(TreeNode root, int sum){
        List<List<Integer>> result = new ArrayList<>();
        //leaf node
        if(root.left == null && root.right == null){
            List<Integer> list = new ArrayList<>();
            if(root.val == sum){
                list.add(root.val);
                result.add(list);
            }
            return result;
        }

        // nonleaf
        List<List<Integer>> leftResult = root.left == null ? new ArrayList<>():dfs(root.left,sum - root.val);
        List<List<Integer>> rightResult = root.right == null ? new ArrayList<>() : dfs(root.right,sum - root.val);

        for(List<Integer> list : leftResult){
            list.add(0,root.val);
        }
        for(List<Integer> list :rightResult){
            list.add(0,root.val);
        }

        result.addAll(leftResult);
        result.addAll(rightResult);

        return result;

    }

}
