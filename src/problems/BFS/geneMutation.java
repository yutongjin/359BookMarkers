package problems.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Yutong Jin
 * @date : 6/15/18
 * @Description :A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 *
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 *
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 *
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 *
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 *
 * Note:
 *
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * Example 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * return: 1
 * Example 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * return: 2
 * Example 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * return: 3
 */

//注意条件！！！
    //一定是通过银行里的数据变成了end才可以！！！所以是变之后的string equals（end）
public class geneMutation {

    public int minMutation(String start, String end, String[] bank) {
        if(bank.length == 0)
            return -1;
        int res = 0 ;
        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[bank.length];
        q.offer(start);
        while(!q.isEmpty()){
            res ++;
            int size = q.size();
            for(int i = 0 ; i < size ; i ++){
                String tmp = q.poll();

                for(int j = 0 ;j < bank.length ; j++){
                    if(!visited[j]){

                        if(isMutation(tmp,bank[j])){
                            if(bank[j].equals(end))
                                return res;
                            q.offer(bank[j]);
                            visited[j] =true;
                        }
                    }
                }
            }
        }//while
        return -1;
    }
    private boolean isMutation(String s1,String s2){
        int count = 0 ;
        for(int i = 0 ; i < 8 ; i++){
            if(s1.charAt(i) != (s2.charAt(i)))
                count++;
        }
        return (count == 1);
    }
}
