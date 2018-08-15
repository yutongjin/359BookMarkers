package Facebook;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author : Yutong Jin
 * @date : 8/8/18
 * @Description :
 * 注意1 ：ceiling >=
 *        higher >
 *    2：遍历两遍不代表n2
 *    3：此方法o(nlgn)加 o(n)
 *    4:遍历两遍，第一遍找交换的第一个位置，第二遍找交换的第二个位置。
 */
public class _31_ {
    public void nextPermutation(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>((o1 , o2) -> (Integer.compare(nums[o1],nums[o2])));
        boolean found = false;
        ts.add(nums.length - 1);
        for(int i = nums.length - 2; i >= 0; i --){
            if(found){
                return ;
            }
            else if(nums[i + 1] >nums[i]){
                // ts.add(i);
                swap(nums,i,ts.higher(i));
                rearange(i + 1,nums);
                found = true;
            }
            else {
                ts.add(i);
            }
        }
        if(!found){
            reverse(nums);
        }
    }
    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private void rearange(int start ,int [] nums){
        Arrays.sort(nums,start,nums.length );
    }
    private void reverse(int [] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++ ;
            end --;
        }
    }
}
