package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/27/18
 * @Description :
 */
public class _22_TopDown implements _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        StringBuilder path = new StringBuilder();
        List<String> result = new ArrayList<>();
        dfs("",0,0,n,path,result);
        return result;
    }
    private void dfs(String par,int left ,int right,int n ,StringBuilder sb,List<String > result){
        //op at node
        sb.append(par);
        if(right == n)
        {
            result.add(new String(sb.toString()));
        }
        // go down to children
        if(left < n){
            dfs("(",left + 1,right,n,sb,result);
        }
        if(right < left){
            dfs(")",left,right + 1,n,sb,result);
        }
        //go up to parent
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
    }
}
