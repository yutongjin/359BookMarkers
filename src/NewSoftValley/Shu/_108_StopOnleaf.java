package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/20/18
 * @Description :
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
//停在叶子节点上就需要伪造case
    //39行
public class _108_StopOnleaf implements _108_I_ConvertSortedArraytoBinarySearchTree{

    @Override
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return dfs(nums,0,nums.length - 1);
    }
    private  TreeNode dfs(int [] nums,int start ,int end){
        if(start == end ){
            return new TreeNode(nums[start]);
        }

        int mid = start + (end - start ) /2;
        TreeNode result = new TreeNode(nums[mid]);
        result.left = start != mid ? dfs(nums,start , mid - 1) : null ;
        result.right = dfs(nums,mid+ 1,end);
        return result;
    }
    }

