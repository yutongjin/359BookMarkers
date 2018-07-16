package NewSoftValley.Xian;

import java.util.*;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class _56_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {

        if(intervals.size() == 0)
            return new ArrayList<>();
        //1 sort by start time
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval o1,Interval o2){
                return Integer.compare(o1.end,o2.end);
            }
        });
        // 2 stack
        Stack<Interval> res =new Stack<>();


        Iterator<Interval> it = intervals.iterator();
        while(it.hasNext()){
            Interval itNext = it.next();
            if(!res.isEmpty() && itNext.start <= res.peek().end){
                Interval tmp =res.pop();
                res.push(new Interval(Math.min(itNext.start,tmp.start),itNext.end));
            }
            else res.push(new Interval(itNext.start,itNext.end));
        }


        List<Interval> result = new ArrayList<>();
        while(!res.isEmpty()){
            result.add(0,res.pop());
        }
        return result;


        // new comparator
        // iterator;
    }
}
