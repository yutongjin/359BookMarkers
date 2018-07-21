package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/18/18
 * @Description :Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 *
 * Example:
 *
 * Input: [1,2,3,4,5]
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 *
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 * Clarification:
 *
 * Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.
 *
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 *
 * Here's an example:
 *
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
 */
//关键 ： 别看那么多点，只关注当前的点就好了
public class _156_BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode newright = null;
        TreeNode newleft = null;
        //ListNode rootright = root.right;

        while(root != null){
            TreeNode rootright = root.right;
            TreeNode rootleft   = root.left;
            root.right = newright;
            root.left = newleft;


            newright = root;
            newleft = rootright;
            root = rootleft;
        }
        return newright;
    }
}
