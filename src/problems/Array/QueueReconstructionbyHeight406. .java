package problems.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author : Yutong Jin
 * @date : 6/21/18
 * @Description :Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
// 比较器 二维数组 arraylist 插入add（ index, value）;
class Array {
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0 )
            return people;

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        ArrayList<int []> tmp = new ArrayList<>();
        int n = people.length;
        for(int i = 0 ; i < n ; i++){
            tmp.add(people[i][1], new int []{people[i][0],people[i][1]});
        }
        int [][] res = new int[n][2];
        for(int i = 0 ; i < tmp.size() ; i ++){
            res[i][0] = tmp.get(i)[0];
            res[i][1] = tmp.get(i)[1];
        }
        return res;



    }
}
