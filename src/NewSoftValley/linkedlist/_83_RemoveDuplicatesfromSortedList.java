package NewSoftValley.linkedlist;

/**
 * @Author : Yutong Jin
 * @date : 7/16/18
 * @Description :Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class _83_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(head != null){//head != null
            while(head.next != null && head.val == head.next.val){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
