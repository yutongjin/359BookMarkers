package BinarySearch;

public class SearchInAMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length - 1;
        int col = 0;
        while(col < matrix[0].length && row >= 0){
            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] < target)
                col++;
            else row--;
        }//while
        return false;
//蛇形走位，从右上角或者左下角开始，类似BST？
    }
}
