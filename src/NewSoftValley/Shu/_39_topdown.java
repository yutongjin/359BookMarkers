package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/28/18
 * @Description :
 */
public class _39_topdown implements _39_CombinationSum{
    public List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for(int i = 0 ; i < a.length ; i++){
            dfs(i,a,target - a[i],result,path);
        }
        return result;
    }
    private void dfs(int index,int [] a , int target,List<List<Integer>> result , List<Integer> path ){
        // op at node
        path.add(a[index]);
        if(target == 0){
            result.add(new ArrayList<>(path));
        }
        // find children;
        if(target > 0){
            for(int i = index ; i < a.length; i++){
                if(target - a[i] >= 0)
                    dfs(i,a,target - a[i] ,result,path);
            }
        }
        path.remove(path.size() - 1);
    }
}
