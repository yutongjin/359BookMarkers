package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _15_ {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ;i++){
            if( i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            int low = i + 1;
            int hi = nums.length - 1;
            while(low < hi){
                if(nums[low] + nums[hi] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[hi]);
                    result.add(new ArrayList<>(list));

                    while(low<hi &&nums[low] == nums[low + 1]) low++;
                    while(low<hi && nums[hi] == nums[hi - 1] ) hi--;
                    low ++;
                    hi--;
                }
                else if(nums[low] + nums[hi] < target)low++;
                else if(nums[low] + nums[hi] > target)hi--;
            }
        }
        return result;
    }
}
