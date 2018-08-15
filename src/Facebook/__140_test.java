package Facebook;

import java.util.*;

/**
 * @Author : Yutong Jin
 * @date : 8/6/18
 * @Description :
 */
public class __140_test {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] map = new Boolean[s.length()];
        dfs(s,s.length() - 1 , dict,map,result,new LinkedList<>());
        return result;
    }
    private void dfs(String s,int index,Set<String> dict,Boolean[] map,List<String> result,List<String>path){
        if((map[index] != null && map[index] == false )|| index < 0 )
        {
            System.out.println(index + "不行直接返回。");
            return ;
        }

        for(int i = 0 ; i <= index; i++){
            System.out.println("要找" + s.substring(i,index + 1));
            System.out.println(dict.contains(s.substring(i,index + 1)));
            if(dict.contains(s.substring(i,index + 1))){
                System.out.println("成功找到" + s.substring(i,index + 1));
                path.add(0,s.substring(i,index + 1));
                if(i == 0){

                    String[] next=  new String[path.size()];
                    Iterator<String> it = path.iterator();
                    int j = 0 ;
                    int k = -1 ;
                    while(it.hasNext()){
                        String str = it.next();
                        next[j] = str;
                        k += str.length();
                        map[k] = true;

                        j ++;
                        System.out.println(j + str);
                    }
                    result.add(new String(String.join(" ",next)));
                    System.out.println("找到一个答案"+ result.get(result.size()-1));
                }
                else {dfs(s,i - 1,dict,map,result,path);
                for(String stt : path)
                    System.out.print(stt + " ");
                    }

                path.remove(0);

            }
           else System.out.println("0到" + i+"现在不可以");
        }
        if( map[index] == null) {
            System.out.println(index + "不行设为false。");
            map[index] = false;
        }
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"});
      List<String> res =new __140_test().wordBreak( s, wordDict);
        for(String ss : res){
            System.out.println(ss);
        }
    }

}
