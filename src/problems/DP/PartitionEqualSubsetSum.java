package DP;

import java.util.Arrays;

/**
 * @Author : Yutong Jin
 * @date : 6/14/18
 * @Description : Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * tip：类似找硬币问题，找到某个数就输出即可
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if(nums.length == 0 )
            return false;
        Arrays.sort(nums);
        boolean res ;
        int sum = 0 ;

        int length = nums.length;
        for(int i = length - 1 ; i >= 0 ; i--){
            sum += nums[i];
        }
        for(int i = length - 1 ; i >= 0 ; i--){
            int cur = 0;
            int j = i ;
            while( j >= 0){
                cur += nums[j];
                if(cur * 2 == sum)
                    return true;
                else if( 2 * cur > sum )
                {
                    cur -= nums[j];
                }
                j --;

            }

        }
        return false;

    }
}
