package NewSoftValley.Shu;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Yutong Jin
 * @date : 7/25/18
 * @Description :
 * //35 行问题， 注意加本点res的时候，注意一种本点构成条件的情况。
 * 而且！！！！+ 优先级比 == 高！！！，
 */
public class _437_Bottomup724 implements _437_ {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return dfs(root,sum)._res;
    }
    private Result dfs(TreeNode root,int sum){
        //base case
        Result result = new Result(0,new HashMap<Integer,Integer>());
        if(root.left == null && root.right == null){
            if(root.val == sum)
            {
                result._res = 1;


            }
            result._hs.put(root.val,1);
            return new Result(result._res,result._hs);
        }
        //general case
        Result leftResult = root.left == null ? new Result(0,new HashMap<Integer,Integer>()) : dfs(root.left,sum) ;
        Result rightResult = root.right == null ? new Result(0,new HashMap<Integer,Integer>()) : dfs(root.right,sum) ;
        //1. add left and right result
        result._res += leftResult._res + rightResult._res;
        //2.add result according to root val
        result._res += (root.val == sum ? 1 :0) + (leftResult._hs.containsKey(sum - root.val) ? leftResult._hs.get(sum - root.val) : 0) + (rightResult._hs.containsKey(sum - root.val) ?rightResult._hs.get(sum - root.val) : 0);

        //3. update hashmap
        HashMap<Integer,Integer> newHashMap = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : leftResult._hs.entrySet()){
            newHashMap.put(entry.getKey() + root.val, entry.getValue());
        }
        for(Map.Entry<Integer,Integer> entry : rightResult._hs.entrySet()){
            newHashMap.put(entry.getKey() + root.val, newHashMap.getOrDefault(entry.getKey() + root.val,0) + entry.getValue());
        }
        newHashMap.put(root.val,newHashMap.getOrDefault(root.val,0) + 1);
        result._hs = newHashMap;
        return new Result(result._res,new HashMap<>(newHashMap));

    }
    class Result{
        int _res;
        HashMap<Integer,Integer> _hs ;
        Result(int res,HashMap<Integer,Integer> hs){
            _hs = hs;
            _res = res;

        }
    }
}
