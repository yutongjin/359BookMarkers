package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 *
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 */
public class _713_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0 ;
        int prod = 1;
        int res = 0 ;
        for(int i = 0 ; i < nums.length; i ++){
            if(nums[i] >= k){
                prod = 1;
                start = i + 1;
                continue;
            }
            prod *= nums[i];
            if(prod < k){
                res += i - start +1;
            }
            else {

                while(prod>= k){
                    prod/= nums[start];
                    start ++;
                }


                res += i - start + 1;
            }
        }
        return res;
    }
}
