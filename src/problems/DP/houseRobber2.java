package problems.DP;

/**
 * @Author : Yutong Jin
 * @date : 6/16/18
 * @Description :You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class houseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 0 )
            return 0;
        if(nums.length == 1)
            return nums[0];
        int  []dp1 = new int [nums.length];
        int  []dp2 = new int [nums.length];

        dp1[0] = 0;//not rob 1st house
        dp1[1] = nums[1];
        dp2[0] = nums[0];// rob 1st house
        dp2[1] = nums[0];
        for(int i = 2 ; i < nums.length   ; i++){
            dp1[i] = Math.max(dp1[i - 1 ],  dp1 [i - 2 ] + nums[i]);
            if(i < nums.length - 1 )
                dp2[i] = Math.max(dp2[i - 1 ],  dp2[i - 2 ] + nums[i]);
        }



        return Math.max(dp1[nums.length - 1 ], dp2[nums.length - 2 ]);
    }
}
