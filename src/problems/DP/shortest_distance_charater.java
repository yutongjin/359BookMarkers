package problems.DP;

/**
 * @Author : Yutong Jin
 * @date : 6/19/18
 * @Description :Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 *
 * Example 1:
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 *
 * Note:
 *
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */
// 两边问题，从两边分别遍历去dp
public class shortest_distance_charater {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) continue;
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n-1; i++) {
            if (dist[i] == Integer.MAX_VALUE) continue;
            else dist[i + 1] = Math.min(dist[i+1], dist[i] + 1);
        }
        for (int i = n-1; i > 0; i--) {
            dist[i-1] = Math.min(dist[i-1], dist[i] + 1);
        }
        return dist;

    }
}
