package NewSoftValley.Xian;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 *
 * Return: [1,2],[1,4],[1,6]
 *
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 *
 * Return: [1,1],[1,1]
 *
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3
 *
 * Return: [1,3],[2,3]
 *
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 * Credits:
 * Special thanks to @elmirap and @StefanPochmann for adding t
 */
public class _373_FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<int []> res = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 == 0 || n2==0)
            return res;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) ->(Integer.compare(nums1[o1[0]] + nums2[o1[1]],nums1[o2[0]] + nums2[o2[1]])));
        boolean[][] visited = new boolean[n1][n2];
        minHeap.offer(new int[]{0,0});
        int count = 0 ;
        while(!minHeap.isEmpty() && count < k){

            int [] tmp = minHeap.poll();
            int i = tmp[0];
            int j = tmp[1];
            visited[i][j] = true;
            res.add(new int []{nums1[i],nums2[j]});
            if( i < n1 - 1 && !visited[i + 1][j]){


                minHeap.offer(new int[]{i + 1,j});

            }
            if( j < n2 - 1 && !visited[i][j + 1])

                minHeap.offer(new int[]{i,j + 1});
            count ++;
        }

        return res;
    }
}
