package NewSoftValley.Xian;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :
You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation:
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Note:
The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.
For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.
 */
public class _632_SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {

        TreeSet<int []> ts = new TreeSet<>(new Comparator<int []>(){
            @Override
            public int compare(int [] o1, int [] o2){
                return Integer.compare(nums.get(o1[0]).get(o1[1]),nums.get(o2[0]).get(o2[1])) != 0?
                        Integer.compare(nums.get(o1[0]).get(o1[1]),nums.get(o2[0]).get(o2[1])) : Integer.compare(o1[0],o2[0]);

            }});
        for(int i = 0 ; i < nums.size(); i++){
            ts.add(new int[]{i,0});
        }
        int[] res = new int[]{nums.get(ts.first()[0]).get(ts.first()[1]),nums.get(ts.last()[0]).get(ts.last()[1])};

        while(ts.size() == nums.size()){

            int[] tmp = ts.pollFirst();
            if(tmp[1] + 1 < nums.get(tmp[0]).size() )
                ts.add(new int[]{tmp[0],tmp[1] + 1});
            else break;
            if(Math.abs(nums.get(ts.last()[0]).get(ts.last()[1]) - nums.get(ts.first()[0]).get(ts.first()[1])) <
                    Math.abs( res[1] - res[0]))
                res = new int []{nums.get(ts.first()[0]).get(ts.first()[1]),
                        nums.get(ts.last()[0]).get(ts.last()[1]) };

        }


        return res;
        //数学归纳法推导
        //输入改成iterator
        // bst  nb

    }
}
