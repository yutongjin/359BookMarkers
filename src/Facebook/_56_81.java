package Facebook;

import java.util.*;

/**
 * @Author : Yutong Jin
 * @date : 8/2/18
 * @Description :
 */
public class _56_81 implements _56_MergeIntervals{
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0)
            return new ArrayList<>();
        Stack<Interval> result = new Stack<>();
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval o1,Interval o2){
                return Integer.compare(o1.start,o2.start);
            }
        });
        result.push(intervals.get(0));
        int size = intervals.size();
        for(int i = 1 ; i < size ; i++ ){
            if(intervals.get(i ).start <= result.peek().end){
                int end = Math.max(intervals.get(i).end,result.peek().end);
                int start = result.peek().start;
                result.pop();
                result.push(new Interval(start,end));

            }
            else   result.push(new Interval(intervals.get(i).start,intervals.get(i).end));
        }
        return new ArrayList<>(result);

    }
}
