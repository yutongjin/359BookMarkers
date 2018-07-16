package NewSoftValley.Xian;

import java.util.PriorityQueue;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
public class _240_Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        //这样写的话 可以不需要 top down 的条件了，关键是看出来左上角到右下角是个bst
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        PriorityQueue<cell> minHeap = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1._val,o2._val)));
        for(int i = 0 ; i < matrix.length ; i++){
            if(matrix[i][0] == target)
                return true;
            minHeap.offer(new cell(i,0,matrix[i][0]));
        }
        while(!minHeap.isEmpty()){
            //minHeap any cell is bigger than target ,return false;
            cell tmp = minHeap.poll();
            if(tmp._val > target)
                return false;
            if(tmp._val == target){
                return true;
            }
            if(tmp._col  < matrix[0].length - 1){
                minHeap.offer(new cell(tmp._row,tmp._col + 1, matrix[tmp._row][tmp._col + 1]));
            }
        }
        return false;

    }
    class cell{
        int _row ;
        int _col;
        int _val;
        public cell(int row,int col,int val){
            _row = row ;
            _col = col;
            _val = val;
        }
    }

}
