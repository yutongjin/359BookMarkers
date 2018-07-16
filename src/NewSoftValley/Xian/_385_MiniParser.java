package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a nested list of integers represented as a string, implement a parser to deserialize it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Note: You may assume that the string is well-formed:
 *
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 *
 * Given s = "324",
 *
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 *
 * Given s = "[123,[456,[789]]]",
 *
 * Return a NestedInteger object containing a nested list with 2 elements:
 *
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *     i.  An integer containing value 456.
 *     ii. A nested list with one element:
 *          a. An integer containing value 789.
 */

import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*
public class _385_MiniParser {
    public NestedInteger deserialize(String s) {

        if(s.charAt(0) != '['){
            return new NestedInteger(Integer.valueOf(s));
        }
        NestedInteger fakepapa = new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(fakepapa);
        int start = 1;
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(c == '-' || c >= '0' && c <= '9')
                continue;
            else if(c == '['){
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                start = i + 1;
            }
            else if(c == ','){
                if( s.charAt(i - 1) >= '0' && s.charAt(i - 1) <='9'){
                    int addNum = Integer.valueOf(s.substring(start,i));
                    stack.peek().add(new NestedInteger(addNum));

                }
                start = i + 1;

            }
            else if( c == ']'){
                if(s.charAt(i - 1)  >= '0' && s.charAt(i - 1) <= '9'){
                    int addNum = Integer.valueOf(s.substring(start,i));
                    stack.peek().add(new NestedInteger(addNum));
                }
                stack.pop();
                start = i + 1;
            }
        }

        return fakepapa.getList().get(0);





    }

}
*/
