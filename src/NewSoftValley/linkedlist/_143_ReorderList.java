package NewSoftValley.linkedlist;

/**
 * @Author : Yutong Jin
 * @date : 7/18/18
 * @Description :Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
//三道题： 1 reverse list
    //    2 快慢指针
    //    3 merge list
public class _143_ReorderList {
    public void reorderList(ListNode head) {
        if(head == null)
            return ;
        ListNode mid = findMiddle(head);
        //head = reverseList(head);

        //break list
        ListNode rightListHead = mid.next;
        mid.next = null;

        //reverse right
        ListNode reversedRight = reverse(rightListHead);
        // merge


        while(reversedRight != null){
            ListNode tmp1 = head.next;
            head.next = reversedRight;
            ListNode tmp2= reversedRight.next;
            reversedRight.next = tmp1;

            reversedRight = tmp2;
            head = tmp1;
        }


    }
    private ListNode findMiddle(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head ;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode oldHead =null;
        ListNode cur =head;
        ListNode tail = null;
        while( cur  !=null){
            oldHead = cur.next;
            cur.next = tail;
            tail = cur;
            cur =  oldHead ;
        }
        return tail;
    }
}
