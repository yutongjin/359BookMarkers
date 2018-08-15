package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/2/18
 * @Description :
 * 暴力搜索
 */
public class _91_DecodeWays {
    public int numDecodings(String s) {
        if(s.length() == 1)
            return s.charAt(0) == '0' ? 0 : 1;
        int []result = new int[1];
        dfs(s,-1,result,false);
        return result[0];
    }
    private void dfs(String s, int index, int[] result,boolean isDouble){
        if(index == s.length() - 1 && (s.charAt(index) != '0' || isDouble))
        {
            result[0] ++;
        }
        if(index >= 0 && index < s.length() - 1 &&  s.charAt(index) =='0' && !isDouble)
        {

            return;
        }

        if(index  < s.length() - 1){
            dfs(s,index + 1,result,false);
        }
        if(index < s.length() - 1 && s.charAt(index + 1) == '1'){
            dfs(s,index + 2,result,true);
        }
        if(index < s.length() - 1 && s.charAt(index + 1) == '2'){

            if(index + 2 < s.length() && s.charAt(index + 2) < '7'){
                dfs(s,index + 2,result,true);
            }
        }

    }
}
