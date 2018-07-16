package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class _3_LongesSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        boolean[] set = new boolean[256];
        int start = 0;
        int res = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            // if not have add in
            if(!set[c]){
                set[c] = true;
            }
            // if have delete from start to last me
            else while(c != s.charAt(start)){// 只要你还没有删到这个东西
                set[s.charAt(start)] = false;
                start ++;
            }
            set[s.charAt(start)] = false;
            start ++;
            //every time update
            res = Math.max(res,i - start + 1);

            //finally add me
            set[c] = true;
        }
        return res;
    }
}
