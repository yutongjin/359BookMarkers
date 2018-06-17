package problems.String;

import java.util.Stack;

/**
 * @Author : Yutong Jin
 * @date : 6/16/18
 * @Description :Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
// 1 stack.push() stack.pop()  queue.offer() queue.poll();
    //2 sb.reverse().toString();
    // sum = 0 ;
    // sum = 1 + 2 + carry
    //carry = sum / base;
    // this = sum % base;
public class StringAdd {
    public String addStrings(String num1, String num2) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < num1.length() ; i ++){
            st1.push(num1.charAt(i));
        }
        for(int i = 0 ; i < num2.length() ; i ++){
            st2.push(num2.charAt(i));
        }
        int sum = 0 ;
        int carry = 0 ;
        for(int i = 0 ; i < Math.max(num1.length(),num2.length())   ; i ++){
            sum += carry;
            if(!st1.isEmpty()){
                sum += st1.pop() - '0';
            }
            if(!st2.isEmpty()){
                sum += st2.pop() - '0';
            }
            carry = sum / 10;
            sb.append(sum % 10);
            sum = 0 ;
        }
        if(carry == 1 )
            sb.append(1);
        return sb.reverse().toString();
    }
}
