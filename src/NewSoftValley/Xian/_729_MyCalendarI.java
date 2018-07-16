package NewSoftValley.Xian;

import java.util.TreeMap;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :
 */
public class _729_MyCalendarI {
    class MyCalendar {

        TreeMap<Integer,Integer> tm;

        public MyCalendar() {
            tm = new TreeMap<>((o1, o2) -> (Integer.compare(o1,o2)));
        }

        public boolean book(int start, int end) {


            if(tm.floorKey(end) != null && tm.floorKey(end) > start)
                return false;
            else  if(tm.ceilingKey(end) != null && tm.get(tm.ceilingKey(end)) < end)
                return false;
            else {
                tm.put(end,start);
                return true;
            }

        }

    }
}
