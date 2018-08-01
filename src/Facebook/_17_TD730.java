package Facebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/30/18
 * @Description :
 * 模板有待推敲一下，28行注意！
 */
public class _17_TD730 {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        String[] map= new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz","*"," ","#"};
        StringBuilder path = new StringBuilder();
        List<String> result = new ArrayList<>();
        dfsStopAtLeaf(map,path,result,digits,0);
        return result;
    }
    private void dfsStopAtNull(String[] map,StringBuilder path,List<String> result,String digits,int index){
        //op at node
        if(index == digits.length()){
            result.add(new String(path.toString()));
            return;
        }
        int num = Integer.valueOf(digits.charAt(index)) - '0' ;

        for(int i = 0 ; i < map[num - 1].length(); i++){
            char c = map[num - 1].charAt(i);
            path.append(c);
            dfsStopAtNull(map,path,result,digits,index+1);
            path.deleteCharAt(path.length() - 1);
            Iterator a = result.iterator();

        }
    }
    private void dfsStopAtLeaf(String[] map,StringBuilder path,List<String> result,String digits,int index){
        //op at node
        int num = Integer.valueOf(digits.charAt(index)) - '0' ;

        if(index == digits.length() - 1){
            for(int i = 0 ; i < map[num - 1].length(); i++){
                char c = map[num - 1].charAt(i);
                path.append(c);
                result.add(new String(path.toString()));
                path.deleteCharAt(path.length() - 1);

            }
        }
        if(index < digits.length() - 1)
            for(int i = 0 ; i < map[num - 1].length(); i++){
                char c = map[num - 1].charAt(i);
                path.append(c);
                dfsStopAtNull(map,path,result,digits,index+1);
                path.deleteCharAt(path.length() - 1);

            }



    }
}
