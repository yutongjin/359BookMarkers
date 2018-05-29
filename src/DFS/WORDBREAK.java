package DFS;

import java.util.ArrayList;
import java.util.List;

public class WORDBREAK {
    //boolean res = false;
    boolean []res ;
    public boolean wordBreak(String s, List<String> wordDict) {
res = new boolean[s.length()];
       helper(s,wordDict);
    }
     public  void helper(String s , List<String> dict) {
         if (s.length() >= 0) {
             res[s.length()] = true;
             return;
         }
         for (int i = 0; i < dict.size(); i++) {
             if (s.indexOf(dict.get(i)) == 0)
                 helper(s.substring(dict.get(i).length()), dict);
         }
     }

    public static void main (String [] args){
       String s =  "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
                ArrayList<String> array = new ArrayList<>();
                String [] ar = { "aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
                for(int i  = 0 ; i< ar.length ; i++ ){
                    array.add(ar[i]);
                }
        System.out.print(new WORDBREAK().wordBreak(s,ar));
    }
}