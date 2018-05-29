import java.util.ArrayList;
import java.util.List;

public class Permutation44 {
        public List<List<Integer>> permute(int[] nums) {
                List<List<Integer>> res = new ArrayList<List<Integer>>();
                List<Integer> tmp = new ArrayList<Integer> ();
                dfs(res,0,nums);
                return res;
        }
        private void dfs( List<List<Integer>> res, int index,int[] nums){
                if(index == nums.length ){
                        List<Integer> tmp = new ArrayList<Integer>();
                        for(int num:nums)
                                tmp.add(num);
                        res.add(new ArrayList<Integer>(tmp));
                }

                for(int i = index;i < nums.length; i++){

                        swap(index,i,nums);//当前层for循环，以index为基础交换i =0:a(bc) i = 1 :b(ac) i = 2 c(ba) index 都是0

                        dfs(res,i + 1,nums);//下一层以index+1 为基础进行交换

                        swap(index,i,nums);//换回来保证每次循环只更换了index 否则index会乱窜


                }
        }
        private void swap(int i,int j,int[] nums){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
        }
}

       /* n! 方法用一个boolean数组， tmp.size() decide 是否需要把tmp add 进 res
       public List<List<Integer>> permute(int[] nums) {


                List<List<Integer>>res = new  ArrayList<List<Integer>>();
                helper(new ArrayList<Integer>(),new boolean[nums.length], nums, res);
                return res;

        }
        public void helper(ArrayList<Integer>tmp ,boolean[] flag , int [] nums , List<List<Integer>> res){
                if(tmp.size() == nums.length){
                        res.add(new ArrayList<Integer>(tmp));
                        return;
                }
                for(int i = 0 ; i< nums.length; i++){
                        if(flag[i])
                                continue;
                        else{
                                flag[i] = true;
                                tmp.add(nums[i]);
                                helper(tmp , flag, nums,res);
                                tmp.remove(tmp.size() - 1);
                                flag[i]= false;
                        }
                }
        }*/