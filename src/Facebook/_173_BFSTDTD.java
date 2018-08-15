package Facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Yutong Jin
 * @date : 8/2/18
 * @Description :
 */
public class _173_BFSTDTD {
    Queue<TreeNode> q ;

    public _173_BFSTDTD(TreeNode root) {
        q = new LinkedList<>();
        addAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }
    private void addAll(TreeNode node ){
        if(node == null)
            return ;
        addAll(node.left);
        q.add(node);
        addAll(node.right);
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext())
            return q.poll().val;
        else return -1;

    }
}
