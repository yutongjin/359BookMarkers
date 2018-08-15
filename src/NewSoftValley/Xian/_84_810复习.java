package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _84_810复习 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] left = new int[n];
        int [] right = new int[n];
        for(int i = 0 ; i < n ;i++){
            if(i == 0){
                left[i] = 0;
            }
            else if(heights[i] <= heights[i - 1]){
                int index = left[i - 1];
                while(index > 0 && heights[i] <= heights [index - 1]){
                    index = left[index - 1];
                }
                left[i] = index;
            }
            else left[i] = i;
        }
        for(int i = n - 1 ; i >= 0 ;i--){
            if(i == n -1){
                right[i] = n - 1;
            }
            else if(heights[i] <= heights[i + 1]){
                int index = right[i + 1];
                while(index < n - 1 && heights[i] <= heights [index + 1]){
                    index = right[index + 1];
                }
                right[i] = index;
            }
            else right[i] = i;
        }
        int res = 0;
        for(int i = 0 ; i <  n;i++){
            res = Math.max(res,(right[i] - left[i] + 1) * heights[i]);
        }
        return res;
    }
}
