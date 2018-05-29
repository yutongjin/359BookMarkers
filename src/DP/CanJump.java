package DP;

public class CanJump {
    public boolean canJump(int[] nums) {
        int canJump = 0 ;
        for(int i = 0 ; i < nums.length ; i ++){
            if(i <= canJump ){
                canJump = Math.max(canJump, i + nums[i]);
            }
            else return false;
        }
        return true;

    }
}
