package String;

/**
 * @Author : Yutong Jin
 * @date : 6/15/18
 * @Description :Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 *
 * Output: True
 *
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 *
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 *
 * Output: True
 *
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

//tip : 从中间开始找，二分，三分，四分，一直找到整个字符串结束。
    //s.substring
    //s.length();
    //string1 equals(string2)
    //if(l% i == 0)

public class repeatedPattern459 {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for(int i = l/2;i >= 1; i--){
            if(l % i == 0){
                int m = l/i;
                StringBuilder sb = new StringBuilder ();
                String str = s.substring(0,i);
                for(int j = 0 ; j < m; j++){
                    sb.append(str);
                }
                if(sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }

}
