package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/23/18
 * @Description : top down 核心停在leaf node！！！！
 */
public class _129_TopDown implements _129_{
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        int result = 0 ;
        List<StringBuilder > list= new ArrayList<>();
        dfs(root,list,new StringBuilder());
        for(StringBuilder path : list){
            result += Integer.valueOf(path.toString());
        }
        return result;
    }
    private void dfs(TreeNode root, List<StringBuilder> list, StringBuilder tmp){
        //op at parent
        tmp.append(root.val);
        if(root.left == null && root.right == null)
        {
            list.add(new StringBuilder(tmp.toString()));
            //return 此处不要return 因为你tmp append 了之后并没有 删掉这个元素；
        }
        //find child
        if(root.left != null)
            dfs(root.left,list,tmp);
        if(root.right != null){
            dfs(root.right,list,tmp);
        }
        // go back to parent;

        tmp.deleteCharAt(tmp.length() - 1);
    }
}
