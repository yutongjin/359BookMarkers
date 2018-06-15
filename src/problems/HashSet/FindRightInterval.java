package problems.HashSet;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author : Yutong Jin
 * @date : 6/15/18
 * @Description :Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.
 *
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 * Example 1:
 * Input: [ [1,2] ]
 *
 * Output: [-1]
 *
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 *
 * Output: [-1, 0, 1]
 *
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 *
 * Output: [-1, 2, -1]
 *
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 */

// 1 巧用treeMap ceilingEntry（key k）  比key k 大一点点点key所在点entry
// 2 题目中给了start 不可能相同，所以用start 作为key
public class FindRightInterval {

  //   Definition for an interval.
     public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }
    class Solution {
        public int[] findRightInterval(Interval[] intervals) {
            int []res = new int[intervals.length];
            TreeMap<Integer,Integer> tm = new TreeMap<>();
            for(int i = 0 ; i < intervals.length ; i ++){
                tm.put(intervals[i].start, i);
            }
            for(int i = 0 ; i < res.length ; i++){
                Map.Entry<Integer, Integer> entry = tm.ceilingEntry(intervals[i].end);
                res[i] = (entry != null)? entry.getValue():-1;
            }
            return res;
        }
    }


}
