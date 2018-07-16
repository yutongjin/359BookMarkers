package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
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
 */
public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int gmin = 1;
        int gmax = 1;
        // 1 乘任何数都为1
        int res = Integer.MIN_VALUE;
        for(int val : nums){
            //此处定义一下防止被篡改掉
            int max = gmax;
            int min = gmin;
            gmax = Math.max(val,Math.max(val* max,val * min));
            gmin= Math.min(val,Math.min(val*max, val *min));
            res = Math.max(res, gmax);
        }
        return res;
    }
}
