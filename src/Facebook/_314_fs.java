package Facebook;

import java.util.*;

/**
 * @Author : Yutong Jin
 * @date : 8/1/18
 * @Description :
 * 其实可以通过min max  来消除 treemap的
 *
 */
public class _314_fs {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new LinkedList<>();
        TreeMap<Integer, List<Integer>> hs = new TreeMap<>();
        Queue<myNode> q = new LinkedList<>();
        q.add(new myNode(0,root));
        while(!q.isEmpty()){
            myNode node = q.remove();
            if(!hs.containsKey(node._index)){
                hs.put(node._index,new ArrayList<>());
            }
            hs.get(node._index).add(node._node.val);
            if(node._node.left != null){
                q.add(new myNode(node._index - 1,node._node.left));
            }
            if(node._node.right != null){
                q.add(new myNode(node._index + 1,node._node.right));
            }
        }

        while(!hs.isEmpty()){
            result.add(hs.pollFirstEntry().getValue());
        }
        return result;
    }

    class myNode{
        int _index;
        TreeNode _node;
        myNode(int index,TreeNode node){
            _node = node;
            _index = index;
        }
    }
}
