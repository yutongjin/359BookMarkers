package NewSoftValley.Xian;

import java.util.PriorityQueue;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class _378_KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length ==0 )
            return 0;
        PriorityQueue<int[]> min = new PriorityQueue<>((o1, o2) -> (Integer.compare(matrix[o1[0]][o1[1]],matrix[o2[0]][o2[1]])));
        int n = matrix.length;
        // first line ,只加第一个元素
        for(int i = 0 ; i < n ;i ++){

            min.offer(new int[]{i,0});

        }
        int res = 0;

        // k times to poll();
        for(int i = 0 ;i < k ; i++){

            int [] tmp = min.poll();
            res = matrix[tmp[0]][tmp[1]];

            // if y axis is less than n - 1; y += 1
            if(tmp[1] < n - 1){
                min.offer(new int []{tmp[0],tmp[1] + 1});
            }

        }
        return res;
        //倒过来找当作业

    }

}
