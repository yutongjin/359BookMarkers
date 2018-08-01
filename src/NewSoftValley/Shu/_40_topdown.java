package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/28/18
 * @Description :
 */
public class _40_topdown implements _40_CombinationSum2{
    public List<List<Integer>> combinationSum2(int[] a, int target) {
        Arrays.sort(a);
        HashSet<List<Integer>> result = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        for(int i = 0 ; i < a.length ; i++){

            if(target >= a[i]){
                dfs(i,a,target - a[i],path,result);
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
    private void dfs(int index, int[] a ,int target,List<Integer> path,HashSet<List<Integer>> result ){
        //op at node
        path.add(a[index]);
        if(target == 0){
            result.add(new ArrayList<>(path));
        }
        if(target > 0){
            for(int i = index + 1; i< a.length ; i++){
                if(i > index + 1 && a[i] == a[i - 1]) // i > index + 1 是点睛之笔
                    continue;
                dfs(i,a,target - a[i],path,result);
            }
        }

        path.remove(path.size() - 1);
    }
}
