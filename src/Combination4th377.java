public class Combination4th377 {
    int res = 0;
    public int combination(int[] nums,int target){
        dfs(nums,target);
        return res;
    }
    public void dfs(int [] nums,int target){
        /*if(target == 0)
        {res ++;
        return;}
        for(int num: nums){
            if(num<=target)
                dfs(nums,target-num);*/


        }

    public static void main(String [] args){
        System.out.print(new Combination4th377().combination(new int[]{1,2},5));
    }
}
