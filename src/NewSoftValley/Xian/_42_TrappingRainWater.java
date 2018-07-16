package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class _42_TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int [] left = new int [n];
        int [] right = new int [n];
        int lmax = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        int res = 0;
        //统计对于每个i，他左边最高的柱子
        for(int i = 0 ; i < n ; i ++){
            if(lmax < height[i]){
                lmax = height[i];

            }
            left[i] = lmax;
        } //统计对于每个i，他右边最高的柱子
        for(int i = n- 1 ; i >= 0 ; i--){
            if(rmax < height[i]){
                rmax = height[i];

            }
            right[i] = rmax;
        }
        //每个i的储水量是左右最高柱子取小后减去自己
        for(int i = 0 ;i < n ; i++){
            res += Math.min(left[i],right[i]) - height[i];
        }
        return res;
    }
}
