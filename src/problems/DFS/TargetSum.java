package DFS;

public class TargetSum {
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {

        dfs(nums,S,0, 0);
        return res;
    }
    private void dfs(int [] nums, int target, int h,int num){
        if(h == nums.length )
        {
            if(target == num )
                res++;
                return;
        }
        dfs(nums,target,h + 1,num - nums[h]);
        dfs(nums,target,h + 1,num + nums[h]);
    }
}