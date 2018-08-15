package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _198_houseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int prev2 = nums[0];
        if(nums.length < 2){
            return prev2;
        }
        int prev1 = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i = 2 ; i < nums.length ; i ++){
            int res = Math.max(prev2 + nums[i] , prev1);
            prev2 = prev1 ;
            prev1 = res;
        }
        return prev1;
    }
}
