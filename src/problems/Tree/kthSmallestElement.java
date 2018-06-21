package problems.Tree;

import java.util.ArrayList;

/**
 * @Author : Yutong Jin
 * @date : 6/21/18
 * @Description :Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */

public class kthSmallestElement {
    public int kthSmallest(Tree.TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res.get(k - 1 );
    }
    private void inorder (Tree.TreeNode root , ArrayList<Integer> res){
        if(root == null)
            return ;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    /*
    * int count = 0;
int result = Integer.MIN_VALUE;

public int kthSmallest(TreeNode root, int k) {
    traverse(root, k);
    return result;
}

public void traverse(TreeNode root, int k) {
    if(root == null) return;
    traverse(root.left, k);
    count ++;
    if(count == k) result = root.val;
    traverse(root.right, k);
}*/
}
