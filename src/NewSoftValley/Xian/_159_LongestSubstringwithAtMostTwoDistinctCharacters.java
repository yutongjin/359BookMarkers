package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Example 1:
 *
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 *
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */
public class _159_LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int start = 0 ;
        int [] freq = new int[256];
        int size = 0 ;
        int res = 0 ;
        // 1 hashmap

        // 2 iterator
        for(int i = 0 ; i < s.length(); i ++){
            char c = s.charAt(i);

            if(freq[c] == 0 && size < 2){
                size++;
            }
            // (3) not exist and after adding size > k
            // delete until the element we delete turns to 0
            else if(freq[c] == 0 && size == 2) {
                while(freq[s.charAt(start)] != 0){
                    freq[s.charAt(start)] --;
                    if(freq[s.charAt(start ++)] == 0)
                        break;
                }
            }
            freq[c]++;
            res = Math.max(res,i - start + 1);
        }

        return res;
    }
}
