package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class _74_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = calculateRow(matrix,target,0,matrix.length - 1);
        if(row == -1)
            return false;
        int left = 0 ;
        int right = matrix[0].length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] > target){
                right = mid - 1;

            }
            else left = mid + 1;

        }
        return false;
    }
    private int calculateRow(int [][] matrix, int target,int start ,int end){
        int pos =  -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(matrix[mid][0] <= target){
                pos = mid;
                start = mid + 1;
            }
            else  end = mid - 1;
        }
        return pos;
    }

}
