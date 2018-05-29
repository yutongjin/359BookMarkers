package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//BFS

public class largestValues_In_EachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int tmp = Integer.MIN_VALUE;
            int size = q.size();
            for(int i = 0 ; i < size ; i ++){
                TreeNode tempNode = q.poll();
                if(tempNode.left!= null)
                    q.add(tempNode.left);
                if(tempNode.right!= null)
                    q.add(tempNode.right);
                if(tempNode.val > tmp)
                    tmp = tempNode.val;

            }
            res.add(tmp);
        }
        return res;

    }
}
