package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _213_houseRobber2 {
    public int rob(int[] nums) {
        if(nums.length ==0)
            return 0;
        if(nums.length < 2){
            return nums[0];
        }
        int rob1Prev2 = nums[0];
        int rob1Prev1 = nums[0];
        for(int i = 2;i < nums.length  - 1; i++){
            int res1 = Math.max(rob1Prev2 + nums[i],rob1Prev1);
            rob1Prev2 = rob1Prev1;
            rob1Prev1 = res1;
        }

        int notRob1Prev2 = 0;
        int notRob1Prev1 = nums[1];
        for(int i = 2;i < nums.length; i++){
            int res2 = Math.max(notRob1Prev2 + nums[i],notRob1Prev1);
            notRob1Prev2 = notRob1Prev1;
            notRob1Prev1 = res2;
        }
        return Math.max(notRob1Prev1,rob1Prev1);
    }
}
