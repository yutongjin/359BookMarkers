package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 6/3/18
 * @Description :
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Permutation47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean []visited = new boolean[nums.length];
        helper(nums,res,new ArrayList<Integer>(),visited);
        return res;
    }
    private void helper(int [] nums,List<List<Integer>> res,ArrayList<Integer> tmp ,boolean []visited  ){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 0 ; i< nums.length; i ++){
            if(visited [i])
                continue;

            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            tmp.add(nums[i]);
            visited[i] = true;
            helper(nums,res,tmp,visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;

        }

    }
}
