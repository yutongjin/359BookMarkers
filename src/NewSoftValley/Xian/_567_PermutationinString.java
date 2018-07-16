package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
 */
public class _567_PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int [] freqS = new int [26];
        int [] freqT = new int [26];
        int diff = s1.length();
        // 1 get s1 hashmap
        int start = 0;
        for(int i = 0 ; i < s1.length(); i++){
            freqT[s1.charAt(i) - 'a']++;
        }

        for(int i = 0 ;i < s2.length(); i++){
            int c = s2.charAt(i) -'a';
            if(freqT[c] == 0) {
                diff = s1.length();
                for(int j = 0 ; j < 26; j++){
                    freqS[j] = 0;
                }
                start = i + 1;
                continue;
            }
            if( freqS[c] < freqT[c]){
                diff--;
                freqS[c]++;
            }
            else {
                while(s2.charAt(start) - 'a' != c ){
                    freqS[s2.charAt(start) - 'a']--;
                    start ++;
                    diff++;
                }
                start ++;
            }
            if(diff == 0)
                return true;
        }
        return false;
    }
}
