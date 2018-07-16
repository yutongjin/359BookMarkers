package NewSoftValley.Xian;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class _228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0 )
            return res;
        int s = nums[0];
        for(int i = 1; i < nums.length ; i++ ){
            if(nums[i] != nums[ i - 1] + 1 ){
                res.add(group(s,nums[i - 1] ));
                s = nums[i];
            }
        }

        res.add(group(s,nums[nums.length - 1 ] ));
        return res;
    }
    private String group(int i , int j){
        if(i == j)
            return String.valueOf(i);
        else return i + "->" + j;
    }
}
