package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/16/18
 * @Description :Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class _113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean isLeaf = true;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                result.add(list);
            }
        } else {
            List<List<Integer>> child1Result = new ArrayList<>();
            List<List<Integer>> child2Result = new ArrayList<>();
            if (root.left != null) {
                child1Result = pathSum(root.left, sum - root.val);

            }
            result.addAll(child1Result);
            if (root.right != null) {
                child2Result = pathSum(root.right, sum - root.val);
            }

            result.addAll(child2Result);

            for (List<Integer> list : result) {
                list.add(0, root.val);
            }

        }
        return result;
    }
}
