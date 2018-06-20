package problems.DP;

/**
 * @Author : Yutong Jin
 * @date : 6/17/18
 * @Description :Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 152. Maximum Product Subarray
 */

// maxHere minHere
    // maxSofar
public class maxProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int max = nums[0];
        int min = nums[0];
        int res = max;
        for(int i = 1; i < nums.length ; i++){
            int curMax = max * nums[i];
            int curMin = min * nums[i];
            max=  Math.max(Math.max(curMax,curMin), nums[i]);
            min=  Math.min(Math.min(curMax,curMin), nums[i]);
            res = Math.max(res,max);
        }
        return res;

    }
}
