package NewSoftValley.Shu;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Yutong Jin
 * @date : 7/16/18
 * @Description :You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class _437_PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null ){
            return 0;
        }
        return dfs(root,sum)._num;
    }
    private Result dfs(TreeNode root,int sum){
        //base case leaf

        if(root.left == null && root.right == null){
            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer> ();
            hm.put(root.val,1);
            return new Result(root.val == sum ? 1 : 0,hm);
        }

        //general case

        Result leftResult = root.left == null ? new Result(0,new HashMap<>()): dfs(root.left,sum );
        Result rightResult = root.right == null ? new Result(0,new HashMap<>()): dfs(root.right,sum );

        int num = (root.val == sum ? 1 : 0 )+ (!leftResult._hm.containsKey(sum - root.val) ? 0 : leftResult._hm.get(sum - root.val) )+ (!rightResult._hm.containsKey(sum - root.val) ? 0 :rightResult._hm.get(sum - root.val)) + leftResult._num + rightResult._num;


        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer> ();
        for(Map.Entry<Integer,Integer> entry : leftResult._hm.entrySet()){
            hm.put(entry.getKey() + root.val,entry.getValue());
        }

        for(Map.Entry<Integer,Integer> entry : rightResult._hm.entrySet()){
            if(!hm.containsKey(entry.getKey() + root.val))
                hm.put(entry.getKey() + root.val,entry.getValue());
            else hm.put(entry.getKey() + root.val,hm.get(entry.getKey() + root.val) + entry.getValue());
        }

        if(!hm.containsKey(root.val))
            hm.put(root.val,1);
        else hm.put(root.val,hm.get(root.val) + 1);

        return new Result(num,hm);



    }
    class Result {
        int _num;
        HashMap<Integer,Integer> _hm;
        public Result(int num,HashMap<Integer,Integer> hm){
            _num = num;
            _hm = hm;
        }
    }
}
