package BinarySearch;

public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int []res = new int []{-1,-1};
        if(nums.length == 0 )
            return res;
        int start = findEqualOrGreater(0,nums.length - 1 , nums , target);
        if(start == nums.length  || nums[start] != target)
            return res;
        int end = findEqualOrGreater(0, nums.length - 1 ,  nums ,  target + 1 );
        return new int []{start,nums[end] == target? end: end-1 };
    }

    private int findEqualOrGreater(int start , int end , int [] nums , int target){
        int   mid ;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(nums[start] == target)
            return start;
        return end;
    }
}
