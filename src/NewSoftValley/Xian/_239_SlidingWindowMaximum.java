package NewSoftValley.Xian;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */

public class _239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[]{};

        if(k <= 0)
            return nums;

        int []  res = new int[nums.length - k + 1];
        TreeSet<Integer> ts = new TreeSet<>((o1, o2)->(Integer.compare(nums[o2],nums[o1]) != 0 ?Integer.compare(nums[o2],nums[o1]):Integer.compare(o1,o2)));
        for(int i = 0 ; i < nums.length ; i++){
            if(i >= k)
                ts.remove(i - k);

            ts.add(i);
            if(i >= k - 1)
                res[i - k + 1] = nums[ts.first()];

        }
        return res;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {

        if( k <= 1)
            return nums;
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return Integer.compare(o2,o1);
            }
        });
        int [] res = new int [nums.length - k + 1];
        for(int i = 0  ;i < nums.length ;i++){
            maxHeap.offer(nums[i]);
            if(i>= k){
                maxHeap.remove(nums[i - k ]);
            }
            if(i >= k - 1)
                res[i -(k - 1)] = maxHeap.peek();


        }

        return res;
    }
}
