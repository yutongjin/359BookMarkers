package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/14/18
 * @Description :Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class _32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0 ;
        int left = 0;
        int right = 0;
        int start = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(right == left ){
                res = Math.max(res,i - start);
                if(c ==')'){
                    start = i + 1;
                }
                if(c == '('){

                    left ++;
                }

            }

            else if(right < left){
                if (c ==')'){
                    right ++;
                }
                if(c == '('){
                    left ++;
                }
            }
        }
        if(right == left){
            res = Math.max(res,s.length() - start);
        }

        left = 0;
        right = 0;
        start = s.length() - 1;
        for(int i = s.length() - 1 ; i >= 0; i--){

            char c = s.charAt(i);
            if(right == left ){
                res = Math.max(res,start - i );
                if(c =='('){
                    start = i - 1;
                }
                if(c == ')'){

                    right ++;
                }

            }
            else if(right > left){
                if (c ==')'){
                    right ++;
                }
                if(c == '('){
                    left ++;
                }
            }
        }
        if(right == left){
            res = Math.max(res,start-s.length());
        }

        return res;
    }
}
