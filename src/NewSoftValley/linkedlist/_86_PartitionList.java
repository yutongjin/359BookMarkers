package NewSoftValley.linkedlist;

/**
 * @Author : Yutong Jin
 * @date : 7/18/18
 * @Description :Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
//用两个链表统计两部分信息，注意记录head 前prev变量，因为当前值有问题时动的是指向head的指针；
public class _86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode newHead = new ListNode(-1);
        ListNode greater = newHead;
        while(head != null){
            if(head.val <x){
                head = head.next;
                prev = prev.next;
            }
            else {
                prev.next = head.next;
                newHead.next = head;
                head.next = null;
                newHead = newHead.next;
                head = prev.next;

            }
        }

        prev.next =greater.next;

        return dummy.next;

    }
}
