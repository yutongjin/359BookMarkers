package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a string, find the length of the longest substring T that contains at most k distinct characters.
 *
 * For example, Given s = “eceba” and k = 2,
 *
 * T is "ece" which its length is 3.
 */
public class _340_LogestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0)
            return 0;
        int start = 0 ;
        int [] freq = new int[256];
        int size = 0 ;
        int res = 0 ;
        // 1 hashmap

        // 2 iterator
        for(int i = 0 ; i < s.length(); i ++){
            char c = s.charAt(i);

            if(freq[c] == 0 && size < k){
                size++;
            }
            // (3) not exist and after adding size > k
            // delete until the element we delete turns to 0
            else if(freq[c] == 0 && size == k) {
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
