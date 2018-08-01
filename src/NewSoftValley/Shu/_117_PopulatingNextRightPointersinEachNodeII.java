package NewSoftValley.Shu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Yutong Jin
 * @date : 8/1/18
 * @Description :
 */
public class _117_PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return ;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){

            // op at node

            int size = q.size();
            TreeLinkNode prev = null;
            for(int i = 0 ; i < size ;i ++){
                TreeLinkNode node = q.remove();
                node.next = prev;
                prev = node;
                if(node.right !=null)
                    q.add(node.right);
                if(node.left != null)
                    q.add(node.left);
            }
        }
    }
}
