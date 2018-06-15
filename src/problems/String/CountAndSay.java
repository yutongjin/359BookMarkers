package String;
/*
* The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"*/

public class CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1;i < n ;i++){
            res = helper(res);
        }
        return res;
    }
    private String helper(String s){
        if(s.equals("1"))
            return "11";
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() - 1; i++){
            if(i + 1 == s.length() - 1)
            {if(s.charAt(i + 1) == s.charAt(i))
                sb.append(count + 1 ).append(s.charAt(i));
            else {sb.append(count ).append(s.charAt(i));
                sb.append('1').append(s.charAt(i + 1));}
                break;
            }
            if(s.charAt(i + 1) != s.charAt(i)){

                sb.append(count);
                sb.append(s.charAt(i));
                count = 1;
            }
            else count ++;
        }
        return sb.toString();
    }
}
