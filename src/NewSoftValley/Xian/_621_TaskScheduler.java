package NewSoftValley.Xian;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class _621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n <= 0)
            return tasks.length;
        //1 统计char 出现的频率
        int [] chars = new int [26];
        for(int i = 0 ; i < tasks.length ; i++){
            chars[tasks[i] - 'A'] ++;
        }
        // 按照频率优先，字母ascii码为次要因素 将每个char以int 类型 放入pq中
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (Integer.compare(chars[o2],chars[o1]) != 0 ?Integer.compare(chars[o2],chars[o1]) : Integer.compare(o1,o2)));
        for(int i= 0 ;i < 26 ; i++){
            if(chars[i] != 0)
                maxHeap.add(i);
        }
        //新建一个arraylist 用来储存不能放的元素
        List<Integer> list = new ArrayList<>();
        int res = 0;
        int idle= 0 ;
        boolean finish = false;
        while(!finish){
            //对大小为k对窗口进行操作
            for(int j = 0 ; j < n + 1 ;j ++){
                if(res == tasks.length)
                    break;
                // 如果 k 窗口没有填满 ， 堆里没有合适的元素，就说明失败
                if(maxHeap.peek() != null){

                    //放char
                    //   sb.append((char)(maxHeap.peek() +'a'));
                    //在hashmap里将其freq 减去1
                    chars[maxHeap.peek()]--;
                    list.add(maxHeap.poll());
                    res ++;
                }
                else idle++;

                //暂时加入到list里



            }
            //把list里还能继续放的元素放回堆中
            for(Integer integer : list){
                if(chars[integer] != 0)
                    maxHeap.offer(integer);

            }
            if(maxHeap.isEmpty())
                finish = true;
            //清空list
            list.clear();

        }

        return res + idle;

    }
}
