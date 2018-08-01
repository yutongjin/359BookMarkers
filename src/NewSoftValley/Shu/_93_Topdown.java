package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author : Yutong Jin
 * @date : 7/27/18
 * @Description :
 */
public class _93_Topdown {
    public List<String> restoreIpAddresses(String s) {

        List<String> res= new ArrayList<>();
    dfs(s,4,12,-1,res,"11",new Stack<String>());
        return res;
}
    private void dfs(String s , int min ,int max,int end,List<String> res,String me ,Stack<String> path){
        //1 op at node
        if(min != 4)
        {
            path.push(me);
        }
        if(min == 0)
        {
            res.add(String.join(".",path));
        }
        //2 go down to children
        int childMin = min - 1;
        int childMax = max - 3;
        int childStart = end + 1;
        for(int childEnd =childStart;childEnd < childStart + 3;childEnd ++){
            if(s.length() - 1 - childEnd >= childMin &&
                    s.length() - 1 - childEnd <= childMax&&
                    (childEnd == childStart || s.charAt(childStart) !='0')
                    && Integer.valueOf(s.substring(childStart,childEnd + 1)) >= 0&&
                    Integer.valueOf(s.substring(childStart,childEnd + 1)) <= 255        ){
                dfs(s,childMin,childMax,childEnd,res,s.substring(childStart,childEnd + 1),path);
            }

        }

        // go up to parent
        if(min != 4)
            path.pop();
    }
}
