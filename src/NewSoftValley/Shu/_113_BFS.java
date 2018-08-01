package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : Yutong Jin
 * @date : 7/30/18
 * @Description :
 */
public class _113_BFS implements _113_ {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<List<Integer>> path = new LinkedList<>();
        Queue<Integer> Sum = new LinkedList<>();

        Sum.offer(sum);
        path.offer(new LinkedList<>());
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node  =  q.remove();
            List<Integer> tmp = path.remove();
            int tmpsum = Sum.remove();

            //op at node
            tmp.add(node.val);
            tmpsum -= node.val;

            if(node.left == null && node.right == null){
                if(tmpsum == 0){
                    result.add(new ArrayList<>(tmp));
                }
            }
            // go down to children
            if(node.left != null){
                path.offer(new LinkedList<>(tmp));
                q.offer(node.left);
                Sum.offer(tmpsum);
            }
            if(node.right != null){
                path.offer(new LinkedList<>(tmp));
                q.offer(node.right);
                Sum.offer(tmpsum);
            }
        }
        return result;
    }
}
