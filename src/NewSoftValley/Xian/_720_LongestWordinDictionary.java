package NewSoftValley.Xian;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 * Note:
 *
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 */
public class _720_LongestWordinDictionary {
    public String longestWord(String[] words) {
        // 1 new a heap by  1st string's length 2nd string compareTo
        PriorityQueue<String> longHeap = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1.length(),o2.length()) != 0 ?
                Integer.compare(o2.length(),o1.length()):
                o1.compareTo(o2)));
        //2 put words into a hashset
        HashSet<String> hs = new HashSet<>();
        hs.add(""); // dummy string
        for(String str : words){
            hs.add(str);
            longHeap.offer(str);
        }
        //3 look for from heap
        while(!longHeap.isEmpty()){

            String res = longHeap.poll();
            StringBuilder sb = new StringBuilder(res);
            while( hs.contains(sb.substring(0,sb.length() -1).toString()))
            {
                //4 start to keep look for
                sb.deleteCharAt(sb.length() -1);
                //5 if we can delete to "" , we find the result
                if(sb.toString().equals(""))
                    return res;
            }
        }
        return "";
    }
}
