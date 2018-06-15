package BinarySearch;

public class SearchInAMatrixI {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0 ;
        int end = matrix.length - 1 ;
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(target == matrix[mid][0])
                return true;
            if(target < matrix[mid][0])
                end = mid;
            else start = mid;
        }
        int line = matrix[end][0] <= target? end : start;
        start = 0;
        end = matrix[line].length - 1 ;
        while(start + 1 < end){
            int mid = start + (end - start ) / 2;
            if(target == matrix[line][mid])
                return true;
            if(target < matrix[line][mid])
                end = mid;
            else start = mid;
        }
        if(matrix[line][start] == target || matrix[line][end] == target)
            return true;
        return false;
    }
}
