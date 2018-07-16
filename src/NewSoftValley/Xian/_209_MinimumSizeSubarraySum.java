package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class _209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int start = 0 ;
        int res = 0 ;
        for(int i = 0 ; i < nums.length ; i ++){
            sum += nums[i];
            if(sum  >= s){
                while(sum - nums[start] >= s){
                    sum -= nums[start];
                    start ++;
                }
                res = res == 0? i - start + 1 : Math.min(res,i - start + 1);
            }
        }
        return res;
    }
}
