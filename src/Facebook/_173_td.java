package Facebook;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author : Yutong Jin
 * @date : 8/2/18
 * @Description :
 */
public class _173_td {
    PriorityQueue<TreeNode> ts = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1.val,o2.val)));
    Queue<TreeNode> q;
    public _173_td(TreeNode root) {
        ts = new PriorityQueue<>((o1,o2) -> (Integer.compare(o1.val,o2.val)));
        q = new LinkedList<>();
        if(root != null)
            q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.remove();

            ts.add(node);
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !ts.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext())
            return ts.poll().val;
        else return -1;

    }
}
