package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 */
public class _85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        //O(n * m); col * row//
        //行很宽的话 用列。作业

        if(matrix.length == 0 || matrix[0].length== 0)
            return 0;
        int res = 0 ;
        int row = matrix.length;
        int col = matrix[0].length;

        int [] heights = new int[col];
        for(int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++){
                if(matrix[i][j] == '1'){
                    heights[j] ++;
                }
                else heights[j] = 0;
            }
            res = Math.max(res, calculateRec(heights));
        }
        return res;
    }
    public int calculateRec(int[] heights) {
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
