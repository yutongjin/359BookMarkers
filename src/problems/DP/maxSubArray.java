package DP;

public class maxSubArray {
    /*
    * from i - 1 to i:
    * DP???? Divide and conquer log(n)???
    * */
    public int maxSubArray(int[] nums) {

        int sumEndingHere = nums[0];
        int maxSoFar = nums[0];
        for(int i = 1; i < nums.length ; i++){
            sumEndingHere = Math.max(nums[i], nums[i] + sumEndingHere);
            maxSoFar = Math.max(sumEndingHere,maxSoFar);
        }
        return  maxSoFar;
    }
}
