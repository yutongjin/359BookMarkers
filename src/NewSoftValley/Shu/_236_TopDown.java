package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/23/18
 * @Description :40 42 行必须用add all ，如果只用等号的话会导致指针问题。
 */
public class _236_TopDown implements _236_{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        dfs(pathP,pathQ,root,p,q,new ArrayList<>());
        int start = 0 ;
        int end = Math.min(pathP.size() - 1 ,pathQ.size() - 1);
        TreeNode pos = null;
        while(start <= end){
            int mid = start +(end - start)/2;
            if(pathP.get(mid) == pathQ.get(mid)){
                pos = pathP.get(mid);
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return pos;
    }
    private void dfs(List<TreeNode> pathP,List<TreeNode> pathQ,TreeNode root,TreeNode p, TreeNode q,List<TreeNode>tmp){
        //op at parent
        tmp.add(root);
        if(root == p)
            pathP.addAll(new ArrayList<>(tmp));
        if(root == q)
            pathQ.addAll(new ArrayList<>(tmp));


        // find child
        if(root.left != null)
            dfs(pathP,pathQ,root.left,p,q,tmp);
        if(root.right != null)
            dfs(pathP,pathQ,root.right,p,q,tmp);
        //go back to parent
        tmp.remove(tmp.size() - 1);
    }
}
