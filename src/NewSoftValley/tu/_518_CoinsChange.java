package NewSoftValley.tu;

import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 8/3/18
 * @Description :
 */
public class _518_CoinsChange implements _518_CoinChange2 {
    public static void main(String[] args) {
        System.out.println(new _518_CoinsChange().change(5,new int[]{1,2,5}));

    }
    public int change(int amount, int[] coins) {
        HashMap<Key,Integer> hm = new HashMap<>();
        return dfs(amount,coins,coins.length - 1,hm);

    }
    private int dfs(int target,int[] coins,int index,HashMap<Key,Integer> hm){

        Key key = new Key(target,index);
        if(hm.containsKey(key)){
            System.out.println("Index " + index+"Target" + target + " 的结果已经算过啦，是" +  hm.get(key));
            return hm.get(key);
        }
        int result = 0 ;
        if(target == 0)

        {
            System.out.println("终于找到了Index " + index+"Target" + target+ " 的结果是" +  result);
            return 1;
        }
        if(target < 0 || index == -1) {
            System.out.println("Index 越界或者target 小于了0" );
            return 0;
        }
        //if(index == coins.length)

        System.out.println("Index是 " + index+  "Target" + target+" 我现在要开始找了，现在的结果是" +  result);
        int a = 0 ;
        //if(index == coins.length)

        while(index >= 0 && target >= 0 ){
            result += dfs(target ,coins,index - 1,hm);
            target -= coins[index];
            a++;
            System.out.println("Index是 " + index+ "已经用完了"+a+"个"+coins[index] +"还差"+  target);

        }
        hm.put(key,result);
        System.out.println("终于tmd算完了，Index " + index+ "Target" + target+ " 的结果是" +  result);
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
