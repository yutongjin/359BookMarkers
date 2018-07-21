package NewSoftValley.Shu;

import NewSoftValley.linkedlist.ListNode;

/**
 * @Author : Yutong Jin
 * @date : 7/20/18
 * @Description :
 */
public class _109_Z1 implements _109_ConvertSortedListtoBinarySearchTree {
    @Override
    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head);
    }
    private TreeNode dfs(ListNode head){
        //base case
        if(head == null)
            return null;

        ListNode mid = findMid(head);

        TreeNode root = new TreeNode(mid.val);
        //head ！= mid 说明此时不是只有1个或者2个点的情况，说明左边还有点
        if(head != mid)
            root.left = dfs(head);
        // 下面这个条件排除了一个点的情况，说明右边还有点
        if(mid.next != null)
            root.right = dfs(mid.next);

        return root;
    }
    private ListNode findMid(ListNode head){

        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = slow;
        while(fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            dummy = slow;
            slow = slow.next;
        }
        //记录slow 前面的那个点，因为需要断链
        if(dummy != slow)
            dummy.next = null;

        return slow;
    }
}
