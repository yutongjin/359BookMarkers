package StackLinked;

import StackLinked.ListNode;

public class RemoveNElementofLL {
  /*  public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
            return null;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = res;//cur很重要，head有可能被删除的

        head = res;

        while(n>0){
            head = head.next;
            n--;
        }
        while(head.next!=null){
            cur=cur.next;
            head=head.next;
        }
        cur.next = cur.next.next;
        return res.next;
        */
    }

