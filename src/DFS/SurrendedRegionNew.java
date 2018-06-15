package DFS;

/**
 * @Author : Yutong Jin
 * @date : 6/14/18
 * @Description : dfs 的题起点一定要弄清楚！！！一定不要乱dfs。
 */
public class SurrendedRegionNew {
        public void solve(char[][] board) {
            if(board.length == 0 || board[0].length == 0 )
                return;

            for(int i = 0 ; i < board[0].length; i ++){
                if(board[0][i] == 'O')
                    dfs(0,i,board);
                if(board[board.length - 1][i] == 'O')
                    dfs(board.length - 1 ,i, board);
            }
            for(int i = 0 ; i < board.length; i ++){
                if(board[i][0] == 'O')
                    dfs(i,0,board);
                if(board[i][board[0].length - 1] == 'O')
                    dfs(i,board[0].length - 1 , board);
            }

            for(int i = 0 ;i < board.length ; i ++)
                for(int j = 0 ; j < board[0].length ; j++){
                    if(board[i][j] == 'O')
                        board[i][j] = 'X';
                    if(board[i][j] == 'T')
                        board[i][j] = 'O';
                }
        }
        private void dfs(int i , int j , char[][] board){
            if(i < 0 || i > board.length - 1|| j < 0 || j > board[0].length - 1 || board[i][j] != 'O')
                return ;
            if(board[i][j] == 'O')
                board[i][j] = 'T';
            dfs(i + 1 , j ,board);
            dfs(i - 1 , j ,board);
            dfs(i , j + 1,board);
            dfs(i, j - 1,board);

        }
/*
* class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int []> res = new ArrayList<int []>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean [][]pac = new boolean [row][col];
        boolean [][]alt = new boolean [row][col];
        Queue<int []> queuea = new LinkedList<int []>();
        Queue<int []> queuep = new LinkedList<int []>();
        for(int i = 0 ; i < row ; i ++){
            queuea.offer(new int[]{i,col - 1});
            queuep.offer(new int[]{i,0});
            pac[i][0] = true;
            alt[i][col - 1] = true;
        }
        for(int i = 0 ; i < col ; i ++){
            queuea.offer(new int[]{row  - 1,i});
            queuep.offer(new int[]{0, i});
            pac[0][i] = true;
            alt[row - 1][i] = true;
        }
       bfs(queuea,alt,matrix);
      bfs(queuep,pac,matrix);
        for(int i = 0 ; i < row;i++)
            for(int j = 0; j <col ; j++){
                if(pac[i][j] && alt[i][j])
                    res.add(new int []{i,j});
            }
        return res;
    }

   private void bfs(Queue<int []> queue, boolean[][] visited, int [][] matrix){
       int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
             while(!queue.isEmpty()){
            int size = queue.size();
            int row = matrix.length;
            int col = matrix[0].length;
            for(int i = 0 ; i <size ; i ++){
                int []cur = queue.poll();

                for(int[] j : dir){
                    int x = j[0] + cur[0];
                    int y = j[1] + cur[1];
                    if(x < 0 || x> row -1 || y < 0 || y > col - 1 || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]])
                        continue;
                    visited[x][y] = true;
                    queue.offer(new int []{x,y});
                }
            }
        }
    }
}*/

}
