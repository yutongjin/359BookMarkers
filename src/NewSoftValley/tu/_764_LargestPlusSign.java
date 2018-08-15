package NewSoftValley.tu;

/**
 * @Author : Yutong Jin
 * @date : 8/10/18
 * @Description :
 */
public class _764_LargestPlusSign{
        public int orderOfLargestPlusSign(int N, int[][] mines) {
            int [][] matrix = new int[N][N];
            for(int i = 0 ; i < N ;i ++)
                for(int j = 0 ; j < N ;j++){
                    matrix[i][j] = 1;
                }
            for(int[] pos : mines){
                matrix[pos[0]][pos[1]] = 0;
            }
            int[][] up = new int[N][N];
            int[][] down = new int[N][N];
            int[][] right = new int[N][N];
            int[][] left = new int[N][N];
            for(int i = 0 ; i < N ;i++){
                for (int j = 0 ; j < N ; j++){
                    if(matrix[i][j] == 0){
                        left[i][j] = 0;
                    }
                    else if(j == 0){
                        left[i][j] =  1;
                    }
                    else {
                        left [i][j] = left[i][j - 1] + 1;
                    }
                }
            }

            for(int i = 0 ; i < N ;i++){
                for (int j =  N - 1 ; j >= 0; j--){
                    if(matrix[i][j] == 0){
                        right[i][j] = 0;
                    }
                    else if(j == N - 1){
                        right[i][j] =  1;
                    }
                    else {
                        right [i][j] = right[i][j +1] + 1;
                    }
                }
            }

            for(int i = N -1 ; i >= 0 ;i--){
                for (int j = 0 ; j < N ; j++){
                    if(matrix[i][j] == 0){
                        down[i][j] = 0;
                    }
                    else if(i == N -1){
                        down[i][j] =  1;
                    }
                    else {
                        down [i][j] = down[i + 1][j] + 1;
                    }
                }
            }

            for(int i = 0 ; i < N ;i++){
                for (int j = 0 ; j < N ; j++){
                    if(matrix[i][j] == 0){
                        up[i][j] = 0;
                    }
                    else if(i == 0){
                        up[i][j] =  1;
                    }
                    else {
                        up [i][j] = up[i - 1][j] + 1;
                    }
                }
            }
            int res = 0;
            for(int i = 0 ; i < N ;i ++){
                for(int j = 0 ; j < N ;j++){
                    if(matrix[i][j] != 0)
                        res = Math.max(res,Math.min(Math.min(up[i][j],down[i][j]),Math.min(left[i][j],right[i][j])));
                }
            }
            return res;



        }
}
