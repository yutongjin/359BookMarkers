package StackLinked;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy1 = head;
        ListNode dummy2 = head.next;
        ListNode even = head.next;
        ListNode odd = head;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = dummy2;
        return dummy1;

    }
}
