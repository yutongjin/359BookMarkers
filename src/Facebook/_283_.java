package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 7/30/18
 * @Description :
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
//In place 所以start 指针表示的是第一个非0所在的位置。

public class _283_ implements  _283_MoveZeroes{
    public void moveZeroes(int[] nums) {
        int start = 9999 ;
        for(int i = 0; i < nums.length ; i++){
            //case 1 :为0，那么就要交换，和谁换呢？和后面第一个不是0的数交换。
            // 如果找到了最后一个元素还没有找到，那就说明后面没有非0元素，那就直接return

            if(nums[i] == 0){
                start = i + 1;//可以这样写，因为只有在发现0的时候我们才会去找第一个不是零的元素
                while(start< nums.length - 1 && nums[start] == 0){
                    start ++;
                }
                if(start >= nums.length )
                    return ;
                swap(nums,start,i);

            }
            //case 2 ： 非0，很简单，start指针 像前挪一步
           // start ++;
        }
    }
    private void swap(int nums[], int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
