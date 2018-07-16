package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 */
public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        //while loop 写一下
        int p = 0;
        int q = height.length - 1;
        int res = 0;
        while(p < q){
            int w = q - p;
            int h = Math.min(height[p],height[q]);
            res = Math.max(res,w * h);
            if(height[p] < height[q]){
                p ++;
            }
            else q--;
        }
        return res;
    }
}
