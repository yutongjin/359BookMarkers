package NewSoftValley.Xian;

import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class _560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        hm.put(0 , 1);
        int sum = 0 ;
        int res= 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];

            if(hm.containsKey(sum - k)){
                res+= hm.get(sum - k);

            }
            if(hm.containsKey(sum))
                hm.put(sum,hm.get(sum) + 1);
            else hm.put(sum,1);
        }
        return res;
    }
}
