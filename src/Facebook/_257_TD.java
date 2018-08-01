package Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/1/18
 * @Description :
 */
public class _257_TD {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null)
            return result;
        ArrayList<String> path = new ArrayList<>();
        dfs(root,path,result);
        return result;
    }
    private void dfs(TreeNode root,   ArrayList<String> path ,   List<String> result ){
        path.add(String.valueOf(root.val));

        if(root.left == null && root.right == null){
            StringBuilder tmp = new StringBuilder();
            for(String str : path){
                tmp.append(str + "->");
            }
            tmp.deleteCharAt(tmp.length() - 1);
            tmp.deleteCharAt(tmp.length() - 1);
            result.add(new String(tmp.toString()));


        }

        if(root.left != null){
            dfs(root.left,path,result);
        }
        if(root.right != null){
            dfs(root.right,path,result);
        }
        path.remove(path.size() - 1);

    }
}
