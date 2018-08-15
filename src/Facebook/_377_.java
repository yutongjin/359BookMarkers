package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/5/18
 * @Description :
 */
public class _377_ {
    public int combinationSum4(int[] nums, int target) {
        int [] map = new int[target + 1];
        for(int i = 0 ; i < map.length ; i++){
            map[i] = -1;
        }
        return dfs(map,nums,target);
    }
    private int dfs(int[] map , int[] nums,int target){
        if(target < 0){
            return 0;
        }
        if(map[target] != -1){
            return map[target];
        }

        if(target == 0){
            return 1;
        }

        int result = 0 ;
        for(int num : nums){
            result += dfs(map,nums,target - num);
        }
        map[target] = result;
        return result;
    }
}
