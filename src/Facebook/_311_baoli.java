package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/2/18
 * @Description :
 */
public class _311_baoli {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;

        int rowB = B.length;
        int colB = B[0].length;

        int[][] result = new int[rowA][colB];
        for(int i = 0 ; i < rowA ; i ++){
            for(int j = 0 ; j < colB ; j++){
                result[i][j] = helper(i,j,A,B);
            }
        }
        return result;
    }

    private int helper(int row,int col , int[][]A,int[][] B){
        int sum = 0 ;
        for(int i = 0 ; i < A[0].length; i++){
            sum += A[row][i] * B[i][col];
        }
        return sum;
    }
}
