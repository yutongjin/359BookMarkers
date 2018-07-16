package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 *
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class _84_LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] left = new int[n];
        int [] right = new int [n];
        int res = 0 ;
        //找到该点往左最多可以走到哪里
        for(int i = 0 ; i < n ; i++){
            left[i] = i;
            while(  left[i] - 1  >= 0 && heights[ left[i] - 1] >= heights[i]){
                left[i]  = left[left[i] - 1];
            }

        }
        //找到该点往右最多可以走到哪里
        for(int i = n - 1 ; i >=0; i--){
            right[i] = i;
            while( right[i] + 1 < n  && heights[right[i] + 1] >= heights[i]){
                right[i] = right[right[i] + 1];
            }

        }
        //遍历取值
        for(int i = 0 ; i < n ; i ++){
            res = Math.max(res,heights[i] * (right[i] - left[i] + 1));
        }
        return res;

    }
}
