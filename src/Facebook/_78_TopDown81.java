package Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 8/1/18
 * @Description :
 */
public class _78_TopDown81 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums,0,result,path);
        result.add(new ArrayList<>());
        return result;
       // System.out.println();

    }
    private void dfs(int[] nums,int index,List<List<Integer>> result, ArrayList<Integer> path ){

        for(int i = index; i < nums.length; i ++){
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            dfs(nums,i + 1,result,path);
            path.remove(path.size() - 1);
        }
    }


}
