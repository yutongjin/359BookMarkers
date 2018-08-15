package Facebook;

import java.util.HashMap;

public class _416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        HashMap<Key,Boolean> hm = new HashMap<>();
        int sum = 0 ;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0)
            return false;
        return dfs(nums,sum / 2,hm,0);
    }
    private boolean dfs(int [] nums,int target,HashMap<Key,Boolean> hm,int index){
        Key key = new Key(target,index);
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        if(target == 0){
            return true;
        }
        if(target < 0 || index == nums.length){
            return false;
        }
        boolean result = dfs(nums,target,hm,index + 1) ||dfs(nums,target - nums[index],hm,index + 1);
        hm.put(key,result);
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
