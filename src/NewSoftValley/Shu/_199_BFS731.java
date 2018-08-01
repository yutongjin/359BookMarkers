package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : Yutong Jin
 * @date : 7/31/18
 * @Description :23 行和26 27 可以替换的
 *
 */
public class _199_BFS731 implements  _199_BinaryTreeRightSideView{
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            //op at node
            int size = q.size();
            result.add(q.peek().val);
            for(int i = 0  ; i < size ; i++){
                TreeNode node = q.remove();
                //if(i == 0)
                  //  result.add(node.val);

                if(node.right != null)
                    q.offer(node.right);
                if(node.left != null)
                    q.offer(node.left);
            }

        }

        return result;
    }
}
