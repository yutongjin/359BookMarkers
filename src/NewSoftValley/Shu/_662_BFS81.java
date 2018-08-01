package NewSoftValley.Shu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Yutong Jin
 * @date : 8/1/18
 * @Description :
 */
public class _662_BFS81 {
    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        if(root == null)
            return 0;
        Queue<myNode> q = new LinkedList<>();
        q.add(new myNode(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int max = 0;
            int min = 0;
            for(int i = 0 ; i < size ; i++){

                myNode node = q.remove();
                if( i == 0 )
                    min = node._index;
                if( i == size - 1 )
                    max = node._index;

                if(node._node.left != null){
                    q.add(new myNode(node._node.left,node._index * 2 + 1));
                }
                if(node._node.right != null){
                    q.add(new myNode(node._node.right,node._index * 2 + 2));
                }
            }
            result = Math.max(result,max - min + 1) ;
        }
        return result;
    }
    private class myNode{
        TreeNode _node;
        int _index;
        myNode(TreeNode node,int index){
            _index = index;
            _node = node;
        }
    }
}
