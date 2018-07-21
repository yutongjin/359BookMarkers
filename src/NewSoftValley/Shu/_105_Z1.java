package NewSoftValley.Shu;

import java.util.HashMap;

/**
 * @Author : Yutong Jin
 * @date : 7/20/18
 * @Description :
 */
//inorder root前面那个元素不是preorder left 最后的那个元素！必须要用等价关系来找
public class _105_Z1 implements _105_ConstructBinarTreefromPreorderandInorderTraversal {

    @Override
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hmp = new HashMap<>();
        HashMap<Integer,Integer> hmi = new HashMap<>();
        for(int i = 0 ; i < preorder.length ; i++){
            hmp.put(preorder[i],i);
            hmi.put(inorder[i],i);
        }
        return dfs(preorder,inorder,hmp,hmi,0,preorder.length - 1,0,inorder.length - 1);
    }
    private TreeNode dfs(int [] preorder,int [] inorder,  HashMap<Integer,Integer> hmp ,  HashMap<Integer,Integer> hmi,int startPre,int endPre,int startIn,int endIn){
        if(startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(preorder[startPre]);
        int x = hmi.get(root.val) -startIn + hmp.get(root.val);
        root.left = dfs(preorder,inorder,hmp,hmi,startPre + 1,x,startIn,hmi.get(root.val) - 1 );
        root.right = dfs(preorder,inorder,hmp,hmi,x+ 1,endPre,hmi.get(root.val)+ 1,endIn);


        return root;
    }
}
