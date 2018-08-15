package NewSoftValley.tu;

import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 8/4/18
 * @Description :
 */
public class _322_ {
    int res;
    public int coinChange( int[] coins,int amount) {
        if(amount == 0)
            return 0;
        //Arrays.sort(coins);
        //    int [] result = new int [1];
        // boolean[] found = new boolean[1];
        HashMap<Key,Integer> hm = new HashMap<>();
        int res = dfs(amount,coins,coins.length - 1,hm);
        return res== Integer.MAX_VALUE ? -1 : res;

    }

    private int dfs(int target,int[] coins,int index,HashMap<Key,Integer> hm){

        Key key = new Key(target,index);
        if(hm.containsKey(key))
            return hm.get(key);

        int result = 0;
        if(target == 0){
            return 0;
        }
        if(index < 0 || target < 0){
            return Integer.MAX_VALUE;
        }
        int child1 =dfs(target ,coins,index - 1,hm) ;
        int child2 =dfs(target - coins[index] ,coins,index,hm);

        result = Math.min(child1, child2 != Integer.MAX_VALUE? child2 + 1: Integer.MAX_VALUE) ;
        hm.put(key,result );

        return result;
    }
    private class Key{
        final int _target;
        final int _index;
        public Key(int target,int index){
            _target = target;
            _index = index;
        }
        @Override
        public boolean equals(Object that){
            return that != null && that instanceof Key&&
                    ((Key) that)._target == _target
                    && ((Key) that)._index == _index;
        }
        @Override
        public int hashCode(){
            return 31 * _target + _index;
        }
    }
}
