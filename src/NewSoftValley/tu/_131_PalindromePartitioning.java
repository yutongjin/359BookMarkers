package NewSoftValley.tu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface _131_PalindromePartitioning {
    public List<List<String>> partition(String s);

    private List<List<String>> dfs(String s,int index,  HashMap<Integer,List<List<String>>> map){
        if(map.containsKey(index)){
            return map.get(index);
        }
        List<List<String>> result = new ArrayList<>();//初始化

        for(int i = 0 ; i<=index; i++){
            if(isPalindrome(i,index,s)){
                if(i == 0){
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(0,index + 1));
                    result.add(list);
                }
                else {

                    for(List<String> list :dfs(s,i-1,map)){ //取出i - 1的结果，加上自己这一段，组成新结果。但是不可以改变i - 1 的结果！！
                        List<String> the = new ArrayList<>(list);
                        the.add(s.substring(i,index + 1));
                        result.add(the);
                    }
                }

            }

        }

        map.put(index,result);

        return result;
    }
    private boolean isPalindrome(int start , int end,String s){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
