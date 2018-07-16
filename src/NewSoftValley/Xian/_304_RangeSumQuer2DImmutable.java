package NewSoftValley.Xian;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class _304_RangeSumQuer2DImmutable {
    class NumMatrix {
        int [][] sum;
        int row;
        int col;
        int[][]_matrix;
        public NumMatrix(int[][] matrix) {
            if(matrix.length == 0 || matrix[0].length == 0)
                return ;

            row = matrix.length ;
            col = matrix[0].length;
            sum  = new int [row + 1][col+ 1];
            for(int i = 1 ; i < row + 1 ; i ++){
                for(int j = 1 ; j < col+ 1 ; j++){
                    sum[i][j] = sum[i][j - 1]+ sum[i - 1][j] + matrix[i - 1][j - 1] - sum[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            return sum[row2 + 1][col2 + 1]-sum[row2  +1][col1] - sum[row1][col2  +1 ] + sum[row1 ][col1];


        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
