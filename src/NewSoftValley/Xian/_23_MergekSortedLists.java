package NewSoftValley.Xian;

import java.util.PriorityQueue;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class _23_MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode( -1);
        ListNode fake = head;
        PriorityQueue<ListNode> min = new PriorityQueue<ListNode>((o1, o2) -> (Integer.compare(o1.val,o2.val)));
        for(ListNode list : lists){
            if(list != null)
                min.add(list);
        }

        while(min.peek() != null){
            ListNode temp = min.poll();
            head.next = temp;
            head = head.next;
            if(temp.next != null)
                min.add(temp.next);
        }
        return fake.next;

    }
}
