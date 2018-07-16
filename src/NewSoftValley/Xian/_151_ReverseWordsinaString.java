package NewSoftValley.Xian;

import java.util.ArrayDeque;
import java.util.Deque;
/*
* Given an input string, reverse the string word by word.

Example:

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.*/
class _151_ReverseWordsinaString {
    public String reverseWords(String s) {
        if(s.length() == 0)
            return "";
        Deque<String> res = new ArrayDeque<>();
        int start = s.charAt(0) == ' ' ? 1 : 0;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == ' '){
                if(s.charAt(i - 1 ) != ' '){
                    res.push(s.substring(start,i));
                }
                start = i + 1 ;
            }
        }
        res.push(s.substring(start , s.length()));

        StringBuilder sb = new StringBuilder();
        while(res.size() > 0) {

            String temp = res.pop();
            if(!temp.isEmpty()) sb.append(temp).append(" ");
        }

        return sb.toString().length()==0? "":sb.toString().substring(0, sb.toString().length()-1);


    }
}
