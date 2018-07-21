package NewSoftValley.Shu;

import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 7/20/18
 * @Description :
 * 一定要在对其的那一端！！！找等价关系，而且一定要找等价关系！！！
 */
public class _106_Z1 implements _106_ConstructBinaryTreefromInorderandPostorderTraversal{
    @Override
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hmpos = new HashMap<>();
        HashMap<Integer,Integer> hmin = new HashMap<>();
        int n = inorder.length;
        for(int i = 0 ; i < n ; i++){
            hmpos.put(postorder[i],i);
            hmin.put(inorder[i],i);
        }


        return dfs(inorder,postorder,hmpos,hmin,0,n - 1,0,n - 1);
    }
    private TreeNode dfs(int [] inorder,int [] postorder,HashMap<Integer,Integer>hmpos, HashMap<Integer,Integer>hmin,int postStart,int postEnd,int inStart,int inEnd){

        //base case
        if(postStart > postEnd || inStart >inEnd)
            return null;

        //general case
        TreeNode result = new TreeNode(postorder[postEnd]);

        int x = hmin.get(result.val) - inStart + postStart;
        result.left = dfs(inorder,postorder,hmpos,hmin,postStart,x - 1,inStart,hmin.get(result.val) - 1);

        result.right = dfs(inorder,postorder,hmpos,hmin,x,postEnd - 1,hmin.get(result.val) + 1,inEnd );

        return result;

    }
}
