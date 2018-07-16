package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class _76_ColorSort {
    public void sortColors(int[] nums) {
        if(nums.length == 0 )
            return ;
        int start = 0 ;
        int end = nums.length - 1;
        int i = 0 ;
        while(i <= end){
            if(nums[i] == 0){
                swap(i,start,nums);
                start ++;
                i++;

            }
            else if(nums [i] == 1){
                i ++;
            }
            else {
                swap(i,end,nums);
                end --;
                //end-- 之后我们不对i 进行操作是因为不知道这时候从end 换过来的元素是什么，之前start 缓过来可以放心地加是因为我们可以保证以i为结尾的subarray肯定小于等于api（
            }
        }


    }
    private void swap(int a ,int b,int [] nums){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
