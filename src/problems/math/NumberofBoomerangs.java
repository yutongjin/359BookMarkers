package problems.math;

import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 6/16/18
 * @Description :Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */

//注意问题！！！是从一个点出发，找出其他点中符合条件的两个点，三个点作为组合，另外两个点可以排列。
    // 1 2 3
    // 1 3 2
    // 2 1 3
    // 2 3 1
    // 3 1 2
    // 3 2 1 假如三个点距离相同的话是六种情况
public class NumberofBoomerangs { public int numberOfBoomerangs(int[][] points) {
    if(points == null || points.length == 0)
        return 0;
    int res = 0 ;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i = 0 ; i < points.length  ; i ++){
        for(int j = 0 ; j < points.length ; j ++){
            if(i == j )
                continue;
            int tmp = distance(points[i], points[j]);
            if(hm.containsKey(tmp))
                hm.put(tmp,hm.get(tmp) + 1 );
            else hm.put(tmp, 1 );
        }
        for(Integer key: hm.keySet() ){
            if(hm.get(key) > 1 )
                res += hm.get(key) *(hm.get(key)- 1) ;
        }
        hm.clear();
    }
    return res ;
}
    private int distance(int [] a, int [] b){
        return (int )(Math.pow(a[0] - b[0],2) + Math.pow(a[1] - b[1], 2));
    }
}
