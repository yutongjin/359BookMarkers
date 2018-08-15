package Facebook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author : Yutong Jin
 * @date : 8/5/18
 * @Description :
 */
public class _139_BUMEMO implements _139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] map = new Boolean[s.length()];
        return dfs(s,s.length() - 1 , dict,map);
    }
    private boolean dfs(String s, int index, Set<String> dict, Boolean[] map){
        if(map[index] != null)
        {
            return map[index];
        }
        boolean result = false;

        if(index < 0 ){
            return false;
        }
        for(int i = 0 ; i <= index; i++){
            if(dict.contains(s.substring(i,index + 1))){
                if(i == 0)
                    return true;
                else  result = result || dfs(s,i - 1,dict,map);
            }
        }
        map[index] = result;
        return result;
    }
}
