package NewSoftValley.Xian;

import java.util.PriorityQueue;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class _295_FindMedianfromDataStream {
    class MedianFinder {

        PriorityQueue<Integer> min = new  PriorityQueue<>((o1, o2) -> (Integer.compare(o1,o2)));
        PriorityQueue<Integer> max= new  PriorityQueue<>((o1,o2) -> (Integer.compare(o2,o1)));
        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {

            if(min.isEmpty() || num >= min.peek())
                min.add(num);
            else max.add(num);

            if((min.size() - max.size() == 2))
                max.add(min.poll());
            else if(min.size() - max.size() == -1)
                min.add(max.poll());
        }

        public double findMedian() {
            if((min.size() + max.size()) % 2 == 1)
                return min.peek();
            else return (min.peek() + max.peek() )/ 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
