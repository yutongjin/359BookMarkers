package String;

import java.util.HashMap;

public class LongestSubstring3 {

        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            int start = 0;
            if(s.length() <= 1)
                return s.length();
            HashMap<Character,Integer> hs = new HashMap<>();
            for(int i = 0 ; i < s.length() ; i ++){
                if(hs.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) >= start){// abba的情况！！！！ start 的单向性！
                    start = hs.get(s.charAt(i)) + 1;
                }
                max = Math.max(max, i - start + 1);
                hs.put(s.charAt(i), i);
            }
            return max;
    }
}
