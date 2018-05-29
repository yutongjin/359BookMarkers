import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

        public List<List<Integer>> subsetsWithDup(int[] nums) {

            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            helper(0,nums,new ArrayList<Integer>(),res);
            return res;
        }
        public void helper(int pos, int [] nums , ArrayList<Integer> tmp , List<List<Integer>> res){
            res.add(new ArrayList<Integer>(tmp));
            for(int i = pos ; i < nums.length ; i ++){
                if(i != pos && nums[i] == nums[i - 1])
                    continue;// cut tree , remove duplicate
                tmp.add(nums[i]);
                helper(i + 1 , nums, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }



}
