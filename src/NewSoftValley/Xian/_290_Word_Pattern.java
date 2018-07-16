package NewSoftValley.Xian;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class _290_Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 || str.length() == 0 )
            return false;
        HashMap<Character,String> hm = new HashMap<>();
        ArrayList<String > sList = new ArrayList<>();
        int start = 0 ;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == ' ')
            {sList.add(str.substring(start,i));
                start = i + 1;
            }
        }
        sList.add(str.substring(start, str.length()) );
        for(int i = 0 ; i < pattern.length() ; i ++){
            char c = pattern.charAt(i);
            if(i >= sList.size())
                return false;
            if(hm.containsKey(c)){
                if( !hm.get(c).equals(sList.get(i)))
                    return false;

            }
            else hm.put(c,sList.get(i));

        }
        HashMap<String,Character> hm2 = new HashMap<>();
        for(int i = 0 ;i  < sList.size() ; i ++){
            if(i >= pattern.length())
                return false;
            char c = pattern.charAt(i);
            if(hm2.containsKey(sList.get(i))){
                if( !hm2.get(sList.get(i)).equals(c))
                    return false;

            }
            else hm2.put(sList.get(i),c);
        }
        return true;
    }
}
