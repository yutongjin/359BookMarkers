package BinarySearch;

public class InsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1 ;
        if(target < nums[0])
            return 0;//初级判断一下
        if(target > nums[nums.length - 1 ])
            return nums.length;
        //find the smallest index that larger than target.
        while(start + 1 < end){
            int mid = start + ( end - start)/2;
            if(nums[mid] > target){
                end = mid;
            }
            else if(nums[mid] == target )
                return mid;
            else start = mid;
        }
//找到了一对start , end进行分情况讨论,此时target 一定在这两个数之间。
        if(nums[end] == target)
            return end;
        if(nums[start] == target)
            return start ;
        return start + 1;

    }
}
