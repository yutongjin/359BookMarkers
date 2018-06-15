package StackLinked;

import java.util.Stack;

/**
 * @Author : Yutong Jin
 * @date : 6/1/18
 * @Description :
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
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
 *
 *
 */
//注意：1，只有}])的情况
//    2，{[(比较多的时候，需要判断stack是否空

public class validParenthesis {
    public boolean isValid(String s) {
        if(s.length() == 0 )
            return true;

        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length(); i ++){
            if(s.charAt(i) == '(' ||s.charAt(i) == '[' || s.charAt(i) == '{')
                st.push(s.charAt(i));
            else {
                if(s.charAt(i) == ')')
                { if(st.isEmpty() ||st.pop()!= '(')
                    return false;}

                else if(s.charAt(i) == ']')
                {if(st.isEmpty() ||st.pop()!= '[')
                    return false;}

                else  if(s.charAt(i) == '}')
                {if(st.isEmpty() ||st.pop()!= '{')
                    return false;}
            }
        }

        return st.isEmpty();
    }
}
