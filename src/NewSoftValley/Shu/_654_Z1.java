package NewSoftValley.Shu;

/**
 * @Author : Yutong Jin
 * @date : 7/20/18
 * @Description :s
 * 构造树，本点信息，如何构造孩子，base case
 */
public class _654_Z1 implements _654_MaximumBinaryTree {

    @Override
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length - 1);
    }
    private TreeNode dfs(int [] nums,int start, int end){
        //base case
        if(start > end )
            return null;
        int maxIndex = start;
        for(int i = start  ; i < end + 1 ; i ++){
            if(nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        TreeNode result = new TreeNode(nums[maxIndex]);

        result.left = dfs(nums,start,maxIndex - 1);
        result.right = dfs(nums,maxIndex + 1, end);
        return result;
    }
}
