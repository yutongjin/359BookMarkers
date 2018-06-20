package problems.matrix;

/**
 * @Author : Yutong Jin
 * @date : 6/19/18
 * @Description :A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 *
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True
 * Explanation:
 * 1234
 * 5123
 * 9512
 *
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
 * Example 2:
 *
 * Input: matrix = [[1,2],[2,2]]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * Note:
 *
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 */
public class toeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length == 0)
            return false;
        for(int i = matrix.length - 2 ; i >= 0 ; i --)
            for(int j = 1 ; j <matrix[0].length ; j ++){
                if(matrix[i][j - 1 ] != matrix[i + 1 ][j])
                    return false;
            }
        return true;

    }
}
