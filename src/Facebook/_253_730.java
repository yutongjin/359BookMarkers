package Facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author : Yutong Jin
 * @date : 7/30/18
 * @Description :
 * // 排序
 * // 维持一个堆，因为如果不这样每次进来都要去找最小的end time 的屋子。
 */
public class _253_730 implements _253_MeetingRoomsII{
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        Arrays.sort(intervals,new Comparator<Interval>(){
                    @Override
                    public int compare(Interval o1,Interval o2){
                        return Integer.compare(o1.start,o2.start) != 0 ?
                                Integer.compare(o1.start,o2.start) : Integer.compare(o1.end,o2.end);
                    }
                }
        );

        for(Interval interval : intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start){
                minHeap.poll();
            }
            minHeap.add(interval.end);
        }
        return minHeap.size();


    }

}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}