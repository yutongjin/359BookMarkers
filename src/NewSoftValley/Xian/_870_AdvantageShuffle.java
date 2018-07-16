package NewSoftValley.Xian;

import java.util.TreeSet;

/**
 * @Author : Yutong Jin
 * @date : 7/14/18
 * @Description :User Accepted: 925
 * User Tried: 1365
 * Total Accepted: 939
 * Total Submissions: 2872
 * Difficulty: Medium
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 * Example 2:
 *
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 */
public class _870_AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        TreeSet<int []> ts = new TreeSet<>((o1, o2) -> (Integer.compare(o1[0],o2[0] ) != 0 ?Integer.compare(o1[0],o2[0]) : Integer.compare(o1[1],o2[1])));
        for(int i = 0 ; i < A.length ; i++){
            ts.add(new int[]{A[i],i});
        }
        int n = A.length;
        int [] res = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(ts.first()[0] > B[i]){
                res[i] = ts.pollFirst()[0];
            }
            else {
                if(ts.higher(new int []{B[i],n}) == null){
                    res[i] = ts.pollFirst()[0];
                }
                else {res[i] = ts.higher(new int []{B[i],n})[0];
                    ts.remove(ts.higher(new int []{B[i],n}));}
            }
        }
        return res;
    }
}
