package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int diff = t.length();
        int start = 0;
        String res = "" ;
        int [] freqS = new int [256];
        int [] freqT = new int [256];
        for(int i = 0 ;i< t.length();i ++){
            freqT[t.charAt(i)]++;
        }

        for(int i= 0 ; i < s.length(); i ++){
            char c = s.charAt(i);
            if(freqT[c] == 0 ){
                continue;
            }
            else if(freqS[c] < freqT[c]){
                freqS[c] ++;
                diff--;
            }
            else {
                freqS[c] ++;
            }
            if(diff == 0){
                while( !(freqT[s.charAt(start)] != 0 && freqS[s.charAt(start)] ==freqT[s.charAt(start)]) ){

                    freqS[s.charAt(start)]--;
                    start ++;

                }
                if(!res.equals(""))
                    res = i - start + 1 < res.length() ? s.substring(start,i + 1) : res;
                else res =  s.substring(start,i + 1);
            }
        }
        return res;
    }
}
