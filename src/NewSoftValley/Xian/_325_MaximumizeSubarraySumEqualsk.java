package NewSoftValley.Xian;

import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 *
 * Example 1:
 *
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 *
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 */
public class _325_MaximumizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0 ;
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i = 0 ;i < nums.length ; i++){
            sum += nums[i];
            //tiaojian很重要

            if(hm.containsKey(sum - k)){
                res = Math.max(res,i - hm.get(sum - k));
            }
            if(!hm.containsKey(sum)){//
                hm.put(sum,i);
            }
        }

        return res;
    }
}
