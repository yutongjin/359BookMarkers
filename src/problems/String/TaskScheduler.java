package problems.String;

import java.util.Arrays;

/**
 * @Author : Yutong Jin
 * @date : 6/16/18
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
//给跪的一道题 据说是fb的高频题
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int [] a = new int[26];
        for(char c : tasks){
            a[c - 'A']++;
        }
        Arrays.sort(a);
        int i = 25;
        while(i >= 0 && a[i] == a[25]) i--;
        return Math.max(tasks.length, (a[25] - 1)* (n + 1 ) + 25 - i );
    }
}
