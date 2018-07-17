package NewSoftValley.Shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Yutong Jin
 * @date : 7/16/18
 * @Description :Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class _129_SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<StringBuilder> res = dfs(root);
        int result = 0;
        for(StringBuilder sb : res){
            result += Integer.valueOf(sb.reverse().toString());
        }
        return result;

    }
    private List<StringBuilder> dfs(TreeNode root){
        //base case leaf node
        List<StringBuilder> res = new ArrayList<>();
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder(root.val + "");
            res.add(sb);
            return res;
        }

        else {
            // general case - non-leaf node
            List<StringBuilder> leftResult = root.left == null ?new ArrayList<>() : dfs(root.left);
            List<StringBuilder> rightResult = root.right == null ? new ArrayList<>() : dfs(root.right);
            res.addAll(leftResult);
            res.addAll(rightResult);

            for(StringBuilder sb : res){
                sb.append(root.val);
            }
            return res;
        }
    }

}
