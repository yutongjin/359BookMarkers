package NewSoftValley.Xian;

import java.util.PriorityQueue;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class _215_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        //将index 放进 堆里
        PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> (Integer.compare(nums[o1],nums[o2])));
        for(int i = 0 ; i < nums.length; i ++){
            if(i < k)
                min.offer(i);
                //堆问题一定注意放进堆里面的是什么东西！！！！是index 所以判断的时候要包起来！！！
            else if(nums[i] > nums[min.peek()]){
                min.poll();
                min.offer(i);
            }

        }
        return nums[min.peek()];//注意这里是索引！是index

    }
}
