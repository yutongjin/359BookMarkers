package Facebook;

import java.util.*;

/**
 * @Author : Yutong Jin
 * @date : 8/5/18
 * @Description :
 */
public class _127_bfsMemo  {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>(wordList);

        HashSet<String> added = new HashSet<>();
        int level = 1 ;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        added.add(beginWord);
        while(!q.isEmpty()){

            final int size = q.size();

            for(int count = 0 ; count < size; count ++){
                String cur = q.remove() ;

                for(int i = 0 ; i < cur.length() ; i++){
                    for(char j = 'a' ; j <='z' ;j++){
                        String next = new StringBuilder(cur).replace(i,i + 1, j  + "").toString();
                        if(dic.contains(next) && next.equals(endWord)){
                            return level + 1;
                        }
                        if(dic.contains(next) && !added.contains(next) ){
                            q.add(next);
                            added.add(next);
                        }
                    }
                }
            }


            level++;
        }
        return 0;
    }
}
