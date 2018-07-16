package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class _541_ReverseStringII {
    public String reverseStr(String s, int k) {
        //base
        int start = 0 ;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        if(s.length() < k){
            return new StringBuilder(s).reverse().toString();
        }
        for(int i = 0 ;i < s.length( ) ; i ++){
            if(count == 2 * k)
            {
                sb.append(new StringBuilder(s.substring(start,start + k )).reverse().toString()).append(s.substring(start + k,start +  2 * k ));
                count = 1;
                start = start + 2 * k;
            }
            else {
                count++;
            }
        }
        if(start != s.length())
            if(start  + k <= s.length() - 1)
                sb.append(new StringBuilder(s.substring(start,start + k )).reverse().toString()).append(s.substring(start + k));
            else
                sb.append(new StringBuilder(s.substring(start)).reverse().toString());
        return sb.toString();
    }
}
