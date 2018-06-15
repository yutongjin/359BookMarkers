package StackLinked;

import java.util.Stack;

public class Add2Numbers{
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> st1 = new Stack<>();
            Stack<Integer> st2 = new Stack<>();
            int carry = 0;
            ListNode dummy = new ListNode(-1);
            while(l1 != null){
                st1.push(l1.val);
                l1 = l1.next;
            }

            while(l2 != null){
                st2.push(l2.val);
                l2 = l2.next;
            }

            while( carry == 1 || (!st1.isEmpty()) || (!st2.isEmpty())){ // carry很重要
                int a1 = 0;
                int a2 = 0;

                if(!st1.isEmpty()){
                    a1 = st1.pop();
                }
                if(!st2.isEmpty()){
                    a2 = st2.pop();
                }
                int digit = (carry + (a1 + a2) )% 10;// carry很重要
                carry = (carry + a1 + a2) / 10;// carry很重要
                ListNode tmp = new ListNode(digit);
                tmp.next = dummy.next;
                dummy.next = tmp;
            }
            return dummy.next;
        }
}
