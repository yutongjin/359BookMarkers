package NewSoftValley.Xian;

import java.util.Stack;

/**
 * @Author : Yutong Jin
 * @date : 7/14/18
 * @Description :Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class _20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c =='{' || c =='(' || c =='[')
                stack.push(c);
            else {if(stack.isEmpty() )
                return false;
                if(c =='}'){
                    if(stack.peek() != '{')
                        return false;
                }
                else if(c ==']'){
                    if(stack.peek() != '[')
                        return false;
                }
                else if(c ==')'){
                    if( stack.peek() != '(')
                        return false;
                }
                stack.pop();
            }
        }
        //结尾需要判断是否非空

        return stack.isEmpty();
    }
}
